package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.webforj.servlet.WebforjServlet;

@SpringBootApplication
public class SpringBoot {

  public static void main(String[] args) {
    SpringApplication.run(SpringBoot.class, args);
  }

  @Bean
  public ServletRegistrationBean<WebforjServlet> webforjServlet() {
    ServletRegistrationBean<WebforjServlet> registrationBean = new ServletRegistrationBean<>(new WebforjServlet(),
        "/*");
    registrationBean.setName("WebforjServlet");
    registrationBean.setLoadOnStartup(1);
    return registrationBean;
  }
}
