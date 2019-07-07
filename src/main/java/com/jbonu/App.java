package com.jbonu;


import com.jbonu.service.ServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class App extends SpringBootServletInitializer implements ApplicationRunner{

        @Autowired
        private ServiceFacade userService;


        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(App.class);
        }

        public static void main(String[] args) {
            SpringApplication.run(App.class, args);
        }

        @Override
        public void run(ApplicationArguments args) throws Exception {
            userService.doService("insert");
        }

        @Bean
        public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
        webServerFactoryCustomizer() {
            return factory -> factory.setContextPath("/demo");
        }

    }