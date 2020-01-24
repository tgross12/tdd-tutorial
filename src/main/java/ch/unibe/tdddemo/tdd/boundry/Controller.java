package ch.unibe.tdddemo.tdd.boundry;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.unibe.tdddemo.tdd.control.DbService;
import ch.unibe.tdddemo.tdd.entity.EmploymentDTO;

@RestController
public class Controller {
  DbService service;

  public Controller(DbService service) {
    this.service = service;
  }

  @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
  public String helloWorld() {
    return "{\"Greeting\":\"Hello world!\"}";
  }

  public List<EmploymentDTO> getEmploymentByGuid(String guid) {
    return null;
  }
}
