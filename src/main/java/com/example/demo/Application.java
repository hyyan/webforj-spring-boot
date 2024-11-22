package com.example.demo;

import com.webforj.App;
import com.webforj.component.button.Button;
import com.webforj.component.toast.Toast;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

public class Application extends App {

  @Override
  public void run() throws WebforjException {
    Frame frame = new Frame();
    Button button = new Button("click me 234324", e-> {
      Toast.show("Hello World");
      console().log("Hello World");
    });

    frame.add(button);
  }
}
