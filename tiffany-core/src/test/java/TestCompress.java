import com.cszjo.tiffany.core.compress.Compress;
import com.cszjo.tiffany.core.compress.LZ4Compress;
import org.junit.Test;

/**
 * Created by hansiming on 2017/10/23.
 */
public class TestCompress {

    @Test
    public void compressTest() throws Exception {
        String testString = "ABCDDDDDDASDASDAfksjd" +
                "lkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDAS" +
                "DASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDDDASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdhABCDDDDD" +
                "DASDASDAfksjdlkghshglkhsd嘻嘻嘻嘻嘻SFVZZZsdfsdgdhgsdhsdh";
        System.out.println(testString.getBytes().length);
//        Compress compress = new GZipCompress();
//        Compress compress = new SnappyCompress();
        Compress compress = new LZ4Compress();
        byte[] compressedData = compress.compress(testString.getBytes());
        System.out.println("compressedData length = " + compressedData.length);
        byte[] data = compress.decompress(compressedData);
        System.out.println("data length = " + data.length);
        String result = new String(data, "UTF-8");
        System.out.println(result);
    }
}
