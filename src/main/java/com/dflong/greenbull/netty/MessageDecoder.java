package com.dflong.greenbull.netty;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import com.alibaba.fastjson.JSON;

import java.nio.charset.Charset;
import java.util.List;

// 接受请求时会经过解码器
public class MessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 可读字节数小于4，说明长度信息不完整
        if (in.readableBytes() < 4) {
            return;
        }

        // 标记读取位置
        in.markReaderIndex();

        // 读取消息长度
        int length = in.readInt();

        // 如果可读字节数小于消息长度，重置读取位置等待更多数据
        if (in.readableBytes() < length) {
            in.resetReaderIndex();
            return;
        }

        // 读取消息内容
        byte[] bytes = new byte[length];
        in.readBytes(bytes);
        String jsonString = new String(bytes, Charset.defaultCharset());

        // 将JSON字符串转换为Message对象
        Message message = JSON.parseObject(jsonString, Message.class);
        out.add(message);
    }
}
