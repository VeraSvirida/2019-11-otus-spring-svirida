package ru.svirida;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
@ConfigurationProperties("application")
public class ApplicationProperty {
    @Value("${application.version}")
    private String version;

    @Value("${application.resource}")
    private Resource questionResource;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

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
