package com.cszjo.tiffany.core.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * ZIP压缩
 * Created by hansiming on 2017/10/23.
 */
public class GZipCompress implements Compress {

    public byte[] compress(byte[] array) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(bos);
        gzipOutputStream.write(array);
        gzipOutputStream.close();
        return bos.toByteArray();
    }

    public byte[] decompress(byte[] array) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPInputStream gzipInputStream = new GZIPInputStream(bis);
        byte[] buf = new byte[Compress.BUFFER_SIZE];
        int n;
        while ((n = gzipInputStream.read(buf)) >= 0) {
            bos.write(buf, 0, n);
        }
        bos.flush();
        gzipInputStream.close();
        return bos.toByteArray();
    }
}
