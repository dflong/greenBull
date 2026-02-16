package com.dflong.greenbull.netty.server;

// NettyServer.java
import com.dflong.greenbull.netty.MessageDecoder;
import com.dflong.greenbull.netty.MessageEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServer {

    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    private final int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();

                            // 解码器：处理粘包，最大长度1024，长度字段在开头，长度字段4字节
                            pipeline.addLast(new LengthFieldBasedFrameDecoder(
                                    1024,    // 最大帧长度
                                    0,       // 长度字段偏移量
                                    4,       // 长度字段长度
                                    0,       // 长度调整值
                                    4        // 需要跳过的字节数
                            ));

                            // 编码器：在消息前添加长度字段
                            pipeline.addLast(new LengthFieldPrepender(4));
                            pipeline.addLast(new MessageDecoder()); // 添加编解码器
                            pipeline.addLast(new MessageEncoder());
                            pipeline.addLast(new ServerHandler()); // 添加自定义处理器
                        }
                    });

            ChannelFuture future = bootstrap.bind(port).sync();
            logger.info("Netty服务端启动成功，端口: {}", port);

            // 等待服务端监听端口关闭
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyServer(8529).start();
    }
}
