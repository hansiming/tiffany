import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hansiming on 2017/10/24.
 */
public class TestLogback {

    Logger testLogger;

    @Before
    public void init() {
        testLogger = LoggerFactory.getLogger(TestLogback.class);
    }

    @Test
    public void testLog() {
        testLogger.info("-----------test---------{}", testLogger);
    }
}
