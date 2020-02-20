package ru.svirida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.svirida.service.Testing;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        ApplicationProperty applicationProperties = applicationContext.getBean(ApplicationProperty.class);
        System.out.println(applicationProperties.getVersion());
        Testing testing = applicationContext.getBean(Testing.class);
        testing.makeTesting();

    }
}

