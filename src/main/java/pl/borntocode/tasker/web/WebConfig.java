package pl.borntocode.tasker.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addStatusController("/status", HttpStatus.BAD_GATEWAY);
        registry.addViewController("/?ndex").setViewName("index");
        registry.addViewController("/error").setViewName("error");
    }
}
