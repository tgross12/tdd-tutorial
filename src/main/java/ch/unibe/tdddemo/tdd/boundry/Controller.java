package ch.unibe.tdddemo.tdd.boundry;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
  public String getEmail() {
    return "{\"Greeting\":\"Hello world!\"}";
  }
}
