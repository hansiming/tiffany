package com.cszjo.tiffany.common.compress;

import java.io.IOException;

/**
 * Created by hansiming on 2017/10/23.
 */
public interface Compress {

    byte[] compress(byte[] array) throws IOException;

    byte[] uncompress(byte[] array) throws IOException;
}
