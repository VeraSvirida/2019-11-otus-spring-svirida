package ru.svirida;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationProperty {
    @Value("${app.resource}")
    Resource questionResource;

    @Bean
    public Resource resource() {
        return questionResource;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("bundle");
        ms.setDefaultEncoding("UTF-8");

        return ms;
    }

    @Bean
    public ResourceBundle resourceBundle() {

        ResourceBundle bundle = ResourceBundle.getBundle("bundle", Locale.ENGLISH);
        return bundle;
    }

}
