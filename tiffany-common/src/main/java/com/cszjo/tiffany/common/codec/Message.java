package com.cszjo.tiffany.common.codec;

/**
 * Created by hansiming on 2017/10/16.
 */
public class Message<T> {

    private Header header;
    private T content;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
