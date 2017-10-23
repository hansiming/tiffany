package com.cszjo.tiffany.core.codec;

/**
 * 0-15	    16-23	  24-31	   32-95	96-127
 * magic	version	  extend   flag	    request id	body content length
 * 魔数	协议版本	24-28	29-30	31
 * Created by hansiming on 2017/10/16.
 */
public class Header {

    private short magic;
    private byte version;
}
