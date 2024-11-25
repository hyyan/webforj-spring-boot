package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.toast.Toast;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.servlet.WebforjServlet;

@SpringBootApplication
public class Application extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    Button button = new Button("click me 234324", e -> {
      Toast.show("Hello World");
      console().log("Hello World");
    });

    frame.add(button);
  }

  @Bean
  public ServletRegistrationBean<WebforjServlet> webforjServlet() {
    ServletRegistrationBean<WebforjServlet> registrationBean = new ServletRegistrationBean<>(new WebforjServlet(),
        "/*");
    registrationBean.setName("WebforjServlet");
    registrationBean.setLoadOnStartup(1);
    return registrationBean;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
