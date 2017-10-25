import com.cszjo.tiffany.core.config.AbstractConfig;
import com.cszjo.tiffany.core.registry.ServiceDiscover;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hansiming on 2017/10/20.
 */
public class TestBeanDefinition {

    @Test
    public void testServiceBeanDefinition() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        AbstractConfig config = context.getBean("com.cszjo.tiffany.api.SampleService", AbstractConfig.class);
        System.out.println(config);
    }

    @Test
    public void testRegistryBeanDefinition() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        ServiceDiscover serviceDiscover = context.getBean("registry", ServiceDiscover.class);
        System.out.println(serviceDiscover);
    }
}
