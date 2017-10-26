package com.cszjo.tiffany.transport.handler;

import com.cszjo.tiffany.core.codec.Message;
import com.cszjo.tiffany.core.codec.Request;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by hansiming on 2017/10/26.
 */
public class TiffanyServerHandler extends SimpleChannelInboundHandler<Message<Request>> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message<Request> msg) throws Exception {

    }
}
