package com.cszjo.tiffany.core.compress;

import java.io.IOException;

/**
 * Created by hansiming on 2017/10/23.
 */
public interface Compress {

    enum CompressType {
        NO_COMPRESS, GZIP_COMPRESS, SNAPPY_COMPRESS, LZ4_COMPRESS
    }

    int BUFFER_SIZE = 256;

    int MAX_BUFFER_SIZE = 1024 * 1024;

    byte[] compress(byte[] array) throws IOException;

    byte[] decompress(byte[] array) throws IOException;
}
