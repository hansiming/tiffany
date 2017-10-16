package com.cszjo.tiffany.transport;

import com.cszjo.tiffany.common.codec.Message;
import com.cszjo.tiffany.common.codec.Request;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by hansiming on 2017/10/16.
 */
public class TiffanyNettyServerHandler extends SimpleChannelInboundHandler<Message<Request>> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message<Request> msg) throws Exception {

    }
}
