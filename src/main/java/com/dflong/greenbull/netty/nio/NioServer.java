package com.dflong.greenbull.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private final int port = 8888;

    public static void main(String[] args) throws IOException {
        NioServer server = new NioServer();
        server.start();
    }

    public void start() throws IOException {
        // 1. 创建 Selector
        selector = Selector.open();

        // 2. 创建 ServerSocketChannel
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);  // 非阻塞模式

        // 3. 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(port));
        System.out.println("服务器启动，监听端口: " + port);

        // 4. 注册 ServerSocketChannel 到 Selector，监听连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 5. 事件循环
        eventLoop();
    }

    private void eventLoop() {
        while (true) {
            try {
                // 6. 阻塞等待就绪的事件
                int readyChannels = selector.select();
                if (readyChannels == 0) {
                    continue;
                }

                // 7. 获取就绪的事件集合
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();  // 移除已处理的 key

                    try {
                        if (key.isValid()) {
                            if (key.isAcceptable()) {
                                // 8. 处理连接事件
                                handleAccept(key);
                            } else if (key.isReadable()) {
                                // 9. 处理读事件
                                handleRead(key);
                            } else if (key.isWritable()) {
                                // 处理写事件
                                handleWrite(key);
                            }
                        }
                    } catch (CancelledKeyException e) {
                        // 连接被关闭
                        key.cancel();
                        if (key.channel() != null) {
                            key.channel().close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();

        // 接受连接
        SocketChannel clientChannel = serverChannel.accept();
        if (clientChannel != null) {
            clientChannel.configureBlocking(false);

            // 注册读事件
            clientChannel.register(selector, SelectionKey.OP_READ);

            InetSocketAddress remoteAddress = (InetSocketAddress) clientChannel.getRemoteAddress();
            System.out.println("新客户端连接: " + remoteAddress.getAddress().getHostAddress() +
                    ":" + remoteAddress.getPort());

            // 发送欢迎消息
            String welcomeMsg = "欢迎连接到NIO服务器!\r\n";
            ByteBuffer buffer = ByteBuffer.wrap(welcomeMsg.getBytes(StandardCharsets.UTF_8));
            clientChannel.write(buffer);

            if (!buffer.hasRemaining()) {
                System.out.println("欢迎消息发送成功");
            }
        }
    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();

        // 创建读取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder message = new StringBuilder();

        try {
            int bytesRead;
            while ((bytesRead = clientChannel.read(buffer)) > 0) {
                buffer.flip();  // 切换为读模式

                // 解码字节为字符串
                String chunk = StandardCharsets.UTF_8.decode(buffer).toString();
                message.append(chunk);

                buffer.clear();  // 清空缓冲区
            }

            if (bytesRead == -1) {
                // 客户端断开连接
                InetSocketAddress address = (InetSocketAddress) clientChannel.getRemoteAddress();
                System.out.println("客户端断开连接: " + address.getPort());
                clientChannel.close();
                key.cancel();
                return;
            }

            if (message.length() > 0) {
                String received = message.toString().trim();
                InetSocketAddress address = (InetSocketAddress) clientChannel.getRemoteAddress();
                System.out.println("收到来自客户端 " + address.getPort() + " 的消息: " + received);

                // 处理消息
                String response = processMessage(received);

                // 注册写事件
                key.interestOps(SelectionKey.OP_WRITE);
                key.attach(response);  // 将响应数据附加到 key
            }
        } catch (IOException e) {
            // 连接异常关闭
            System.out.println("客户端异常断开");
            clientChannel.close();
            key.cancel();
        }
    }

    private void handleWrite(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        String response = (String) key.attachment();

        if (response != null) {
            // 发送响应
            ByteBuffer buffer = ByteBuffer.wrap((response + "\r\n").getBytes(StandardCharsets.UTF_8));

            while (buffer.hasRemaining()) {
                clientChannel.write(buffer);
            }

            System.out.println("响应发送完成: " + response);
        }

        // 重新注册读事件
        key.interestOps(SelectionKey.OP_READ);
        key.attach(null);
    }

    private String processMessage(String message) {
        // 简单的消息处理逻辑
        if ("time".equalsIgnoreCase(message)) {
            return "当前时间: " + new java.util.Date();
        } else if ("exit".equalsIgnoreCase(message)) {
            return "再见!";
        } else if ("help".equalsIgnoreCase(message)) {
            return "支持的命令: time, exit, help";
        } else {
            return "ECHO: " + message;
        }
    }

    public void close() {
        try {
            if (selector != null && selector.isOpen()) {
                selector.close();
            }
            if (serverSocketChannel != null && serverSocketChannel.isOpen()) {
                serverSocketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}