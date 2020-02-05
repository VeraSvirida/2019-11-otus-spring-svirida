package ru.svirida;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.svirida.service.Testing;

import java.io.IOException;

@ComponentScan
public class Main {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Testing testing = context.getBean(Testing.class);
        testing.makeTesting();
    }

}

