package com.chenlw.spring.example;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringBeanFactoryTest {

    public static void main(String[] args) {
        // Spring 应用程序被加载到内存中时，框架利用了上面的配置文件来创建所有已经定义的 beans，并且按照标签的定义为它们分配一个唯一的 ID。
        // 你可以使用标签来传递在创建对象时使用不同变量的值。
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        HelloWorld obj = (HelloWorld) beanFactory.getBean("helloWorld");
        obj.getMessage();
    }

}