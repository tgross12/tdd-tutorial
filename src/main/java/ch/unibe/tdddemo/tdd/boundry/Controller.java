package ch.unibe.tdddemo.tdd.boundry;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.unibe.tdddemo.tdd.control.DbService;
import ch.unibe.tdddemo.tdd.entity.EmploymentDTO;
import ch.unibe.tdddemo.tdd.exception.NoResultFoundException;

@RestController
public class Controller {
  DbService service;

  public Controller(DbService service) {
    this.service = service;
  }

  @GetMapping(value = "/employmentbyguid", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<EmploymentDTO> getEmploymentByGuid(@RequestParam String guid) throws NoResultFoundException {
    List<EmploymentDTO> employment = service.getEmployment(guid);
    if (employment.isEmpty()) {
      throw new NoResultFoundException();
    } else {
      return employment;
    }
  }
}
