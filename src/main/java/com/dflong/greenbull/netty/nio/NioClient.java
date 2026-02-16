package com.dflong.greenbull.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class NioClient {
    private Selector selector;
    private SocketChannel socketChannel;
    private final String host = "127.0.0.1";
    private final int port = 8888;
    private volatile boolean running = true;

    public static void main(String[] args) throws IOException {
        NioClient client = new NioClient();
        client.start();
    }

    public void start() throws IOException {
        // 1. 创建 Selector
        selector = Selector.open();

        // 2. 创建 SocketChannel
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        // 3. 连接服务器（非阻塞）
        boolean connected = socketChannel.connect(new InetSocketAddress(host, port));

        if (connected) {
            // 立即连接成功
            System.out.println("已连接到服务器");
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else {
            // 注册连接事件
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }

        // 4. 启动接收线程
        new Thread(this::receiveMessages, "Client-Receiver").start();

        // 5. 启动发送线程
        new Thread(this::sendMessages, "Client-Sender").start();
    }

    private void receiveMessages() {
        while (running) {
            try {
                // 等待就绪的事件
                int readyChannels = selector.select(1000);
                if (readyChannels == 0) {
                    continue;
                }

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    keyIterator.remove();

                    if (!key.isValid()) {
                        continue;
                    }

                    if (key.isConnectable()) {
                        handleConnect(key);
                    } else if (key.isReadable()) {
                        handleRead(key);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void handleConnect(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        if (channel.finishConnect()) {
            System.out.println("连接服务器成功");
            // 注册读事件
            key.interestOps(SelectionKey.OP_READ);
        } else {
            System.out.println("连接失败");
            key.cancel();
            channel.close();
            running = false;
        }
    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder message = new StringBuilder();

        try {
            int bytesRead;
            while ((bytesRead = channel.read(buffer)) > 0) {
                buffer.flip();
                String chunk = StandardCharsets.UTF_8.decode(buffer).toString();
                message.append(chunk);
                buffer.clear();
            }

            if (bytesRead == -1) {
                // 服务器关闭连接
                System.out.println("服务器断开连接");
                channel.close();
                key.cancel();
                running = false;
                return;
            }

            if (message.length() > 0) {
                String received = message.toString().trim();
                System.out.println("收到服务器响应: " + received);
            }
        } catch (IOException e) {
            System.out.println("读取数据异常: " + e.getMessage());
            channel.close();
            key.cancel();
            running = false;
        }
    }

    private void sendMessages() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入消息 (输入 'exit' 退出):");

        while (running && scanner.hasNextLine()) {
            String message = scanner.nextLine().trim();

            if (message.isEmpty()) {
                continue;
            }

            if ("exit".equalsIgnoreCase(message)) {
                System.out.println("正在关闭连接...");
                running = false;
                sendToServer(message);
                break;
            }

            sendToServer(message);
        }

        scanner.close();
        close();
    }

    private void sendToServer(String message) {
        try {
            if (socketChannel != null && socketChannel.isConnected()) {
                ByteBuffer buffer = ByteBuffer.wrap((message + "\r\n").getBytes(StandardCharsets.UTF_8));

                while (buffer.hasRemaining()) {
                    socketChannel.write(buffer);
                }

                System.out.println("消息已发送: " + message);
            } else {
                System.out.println("未连接到服务器");
            }
        } catch (IOException e) {
            System.out.println("发送消息失败: " + e.getMessage());
            running = false;
        }
    }

    public void close() {
        running = false;
        try {
            if (selector != null && selector.isOpen()) {
                selector.wakeup();
                selector.close();
            }
            if (socketChannel != null && socketChannel.isOpen()) {
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}