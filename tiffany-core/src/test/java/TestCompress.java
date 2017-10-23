import com.cszjo.tiffany.common.compress.Compress;
import com.cszjo.tiffany.common.compress.GZipCompress;
import com.cszjo.tiffany.common.compress.SnappyCompress;
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
        Compress compress = new SnappyCompress();
        byte[] compressedData = compress.compress(testString.getBytes());
        System.out.println("compressedData length = " + compressedData.length);
        byte[] data = compress.uncompress(compressedData);
        System.out.println("data length = " + data.length);
        String result = new String(data, "UTF-8");
        System.out.println(result);
    }
}
