package com.dflong.greenbull.netty.client;

// NettyClient.java
import com.dflong.greenbull.netty.Message;
import com.dflong.greenbull.netty.MessageDecoder;
import com.dflong.greenbull.netty.MessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyClient {

    private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);

    private final String host;
    private final int port;

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Message sendMessage(Message message) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        ClientHandler clientHandler = new ClientHandler();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            // 解码器
                            pipeline.addLast(new LengthFieldBasedFrameDecoder(
                                    1024, 0, 4, 0, 4));

                            // 编码器
                            pipeline.addLast(new LengthFieldPrepender(4));
                            pipeline.addLast(new MessageDecoder());
                            pipeline.addLast(new MessageEncoder());
                            pipeline.addLast(clientHandler);
                        }
                    });

            ChannelFuture future = bootstrap.connect(host, port).sync();
            logger.info("连接到服务端 {}:{}", host, port);


            System.out.println("bootstrap hashCode" + bootstrap.hashCode());
            // 发送消息
            future.channel().writeAndFlush(message);

            // 等待响应（超时时间10秒）
            future.channel().closeFuture().await(10000);

            return clientHandler.getResponse();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NettyClient client = new NettyClient("localhost", 8529);

        // 测试发送不同类型的消息
        Message echoMsg = new Message("ECHO", "Hello Netty Server!");
        Message timeMsg = new Message("TIME", "");

        for (int i = 0; i < 10; i ++) {
            Message response1 = client.sendMessage(echoMsg);
            System.out.println("收到响应: " + i + response1);

        }

    }
}