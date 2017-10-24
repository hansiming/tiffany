package com.cszjo.tiffany.core.compress.impl;

import com.cszjo.tiffany.core.compress.Compress;

import java.io.IOException;

/**
 * Created by hansiming on 2017/10/23.
 */
public class NoCompress implements Compress {

    public byte[] compress(byte[] array) throws IOException {
        return array;
    }

    public byte[] decompress(byte[] array) throws IOException {
        return array;
    }
}
