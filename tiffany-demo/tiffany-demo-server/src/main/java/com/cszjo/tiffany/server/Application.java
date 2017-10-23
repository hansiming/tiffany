package com.cszjo.tiffany.server;

import com.cszjo.tiffany.common.config.AbstractConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hansiming on 2017/10/23.
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        AbstractConfig config = (AbstractConfig)context.getBean("com.cszjo.tiffany.api.SampleService");
        System.out.println(config);
    }
}