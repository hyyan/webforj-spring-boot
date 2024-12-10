package com.example.demo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.google.common.io.CharStreams;
import com.webforj.App;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.toast.Toast;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;
import com.webforj.exceptions.WebforjRuntimeException;
import com.webforj.servlet.WebforjServlet;

@SpringBootApplication
public class Application extends App {

  @Override
  public void run() throws WebforjException {
    console().log(System.getProperty("com.basis.bbj.web.app.client.Message.level"));
    Frame frame = new Frame();
    Button button = new Button("click me 234324", e -> {
      Toast.show("Hello World");
      console().log("Hello World");
      throw new WebforjRuntimeException("Hello World");
    });

    frame.add(button);
    try {
      // Does not work 
      String resource = "/com/basis/web/components/messages/BuildButtonMessage.min.js";

      // It works
      // String resource = "/com/basis/web/components/messages/BuildButtonMessage.min.js";
      
      InputStream is = getClass().getClassLoader()
          .getResourceAsStream(resource);
      if (null != is) {
        try (Reader reader = new InputStreamReader(is,
            StandardCharsets.UTF_8)) {
          final String js = CharStreams.toString(reader);
          console().log(js);
        }
      } else {
        console().log("Resource not found: " + resource);
      }
    } catch (Exception e) {
      console().error(e.getMessage());
    }
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
