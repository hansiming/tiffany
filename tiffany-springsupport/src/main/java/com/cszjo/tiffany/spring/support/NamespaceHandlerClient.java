package com.cszjo.tiffany.spring.support;

import com.cszjo.tiffany.spring.support.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hansiming on 2017/10/18.
 */
public class NamespaceHandlerClient {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        Student s = (Student) ctx.getBean("student");
        System.out.println(s.toString());
    }
}
