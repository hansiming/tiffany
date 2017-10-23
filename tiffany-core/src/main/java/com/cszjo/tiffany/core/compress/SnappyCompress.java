package com.cszjo.tiffany.core.compress;

import org.xerial.snappy.Snappy;

import java.io.IOException;

/**
 * Created by hansiming on 2017/10/23.
 */
public class SnappyCompress implements Compress {

    public byte[] compress(byte[] array) throws IOException {
        if (array == null)
            return null;
        return Snappy.compress(array);
    }

    public byte[] decompress(byte[] array) throws IOException {
        if (array == null)
            return null;
        return Snappy.uncompress(array);
    }
}