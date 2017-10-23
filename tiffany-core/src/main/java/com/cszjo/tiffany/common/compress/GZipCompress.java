package com.cszjo.tiffany.common.compress;

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

    private static final int BUFFER_SIZE = 256;

    @Override
    public byte[] compress(byte[] array) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(bos);
        gzipOutputStream.write(array);
        gzipOutputStream.flush();
        gzipOutputStream.close();
        return bos.toByteArray();
    }

    @Override
    public byte[] uncompress(byte[] array) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPInputStream gzipInputStream = new GZIPInputStream(bis);
        byte[] buf = new byte[BUFFER_SIZE];
        int n;
        while ((n = gzipInputStream.read(buf)) >= 0) {
            bos.write(buf, 0, n);
        }
        bos.flush();
        gzipInputStream.close();
        return bos.toByteArray();
    }
}
