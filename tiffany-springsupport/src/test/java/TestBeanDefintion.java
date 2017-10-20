import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hansiming on 2017/10/20.
 */
public class TestBeanDefintion {

    @Test
    public void testStudentBeanDefintion() throws Exception {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
    }
}
