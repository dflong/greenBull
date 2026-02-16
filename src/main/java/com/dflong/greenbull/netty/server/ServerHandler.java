package com.dflong.greenbull.netty.server;

import com.dflong.greenbull.netty.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandler extends SimpleChannelInboundHandler<Message> {

    private static final Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        logger.info("服务端收到消息: {}", msg);

        // 根据消息类型处理业务逻辑
        String responseContent;
        switch (msg.getType()) {
            case "ECHO":
                responseContent = "服务端回显: " + msg.getContent();
                break;
            case "TIME":
                responseContent = "当前服务器时间: " + System.currentTimeMillis();
                break;
            default:
                responseContent = "未知消息类型: " + msg.getType();
        }

        // 发送响应消息
        Message response = new Message("RESPONSE", responseContent);
        // 写回消息
        ctx.writeAndFlush(response);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端连接: {}", ctx.channel().remoteAddress());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端断开连接: {}", ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("服务端异常", cause);
        ctx.close();
    }
}