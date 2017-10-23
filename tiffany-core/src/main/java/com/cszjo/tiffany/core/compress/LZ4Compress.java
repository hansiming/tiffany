package com.cszjo.tiffany.core.compress;

import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4SafeDecompressor;

import java.io.IOException;

/**
 * Created by hansiming on 2017/10/23.
 */
public class LZ4Compress implements Compress {

    LZ4Factory factory = LZ4Factory.fastestInstance();

    public byte[] compress(byte[] array) throws IOException {
        LZ4Compressor compressor = factory.fastCompressor();
        return compressor.compress(array);
    }

    public byte[] decompress(byte[] array) throws IOException {
        LZ4SafeDecompressor decompressor = factory.safeDecompressor();
        return decompressor.decompress(array, MAX_BUFFER_SIZE);
    }
}
