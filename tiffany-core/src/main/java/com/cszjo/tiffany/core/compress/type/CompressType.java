package com.cszjo.tiffany.core.compress.type;

/**
 * Created by hansiming on 2017/10/26.
 */
public enum CompressType {

    NO_COMPRESS((byte) 0, "none"), GZIP_COMPRESS ((byte) (1 << 3), "gzip"),
    SNAPPY_COMPRESS((byte) (1 << 4), "snappy"), LZ4_COMPRESS((byte) (1 << 3 & 1 << 4), "lz4");

    private byte value;
    private String name;

    CompressType(byte value,String name) {
        this.value = value;
        this.name = name;
    }

    public byte getValueByName(String name) {
        if (name.equals(NO_COMPRESS.name))
            return NO_COMPRESS.value;
        else if (name.equals(GZIP_COMPRESS.name))
            return GZIP_COMPRESS.value;
        else if (name.equals(SNAPPY_COMPRESS.name))
            return SNAPPY_COMPRESS.value;
        else
            return LZ4_COMPRESS.value;
    }

    public String getName() {
        return name;
    }
}
