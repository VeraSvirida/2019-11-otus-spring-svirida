package ru.svirida;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.svirida.service.Testing;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Testing testing = context.getBean(Testing.class);
        testing.makeTesting();
    }

}

