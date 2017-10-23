import com.cszjo.tiffany.core.serialize.KryoSerializetion;
import com.cszjo.tiffany.core.serialize.Serializable;
import org.junit.Test;

/**
 * Created by hansiming on 2017/10/20.
 */
public class TestSerializetion {

    @Test
    public void testKryoSerilizetion() throws Exception {

        Serializable serializable = new KryoSerializetion();
        byte[] b = serializable.serialize("abc");

        String result = serializable.deserialize(b, String.class);
        System.out.println(result);
    }
}
