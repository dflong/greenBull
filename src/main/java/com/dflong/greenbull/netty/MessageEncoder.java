package com.dflong.greenbull.netty;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import com.alibaba.fastjson.JSON;

import java.nio.charset.Charset;

// 返回结果时会经过编码器
public class MessageEncoder extends MessageToByteEncoder<Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        // 将消息对象转换为JSON字符串
        String jsonString = JSON.toJSONString(msg);
        byte[] bytes = jsonString.getBytes(Charset.defaultCharset());

        // 写入数据长度（4字节）
        out.writeInt(bytes.length);
        // 写入数据内容
        out.writeBytes(bytes);
    }
}