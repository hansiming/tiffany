package com.cszjo.tiffany.core.codec;

/**
 * 0-15	    16-23	  24-31	   32-95	    96-127
 * magic	version	  extend   request id	body content length
 * extend
 * 0-2         3-4       5-6                            7
 * serialize   compress  0->normal 1->hb 2->exception   0->req 1->res
 * Created by hansiming on 2017/10/16.
 */
public class Header {

    private short magic;
    private byte version;
    private byte extend;
    private long requestId;
    private int bodySize;

    public Header(short magic, byte version, byte extend, long requestId, int bodySize) {
        this.magic = magic;
        this.version = version;
        this.extend = extend;
        this.requestId = requestId;
        this.bodySize = bodySize;
    }

    public short getMagic() {
        return magic;
    }

    public void setMagic(short magic) {
        this.magic = magic;
    }

    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public byte getExtend() {
        return extend;
    }

    public void setExtend(byte extend) {
        this.extend = extend;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public int getBodySize() {
        return bodySize;
    }

    public void setBodySize(int bodySize) {
        this.bodySize = bodySize;
    }
}
