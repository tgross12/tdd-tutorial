package ch.unibe.tdddemo.tdd.boundry;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import ch.unibe.tdddemo.tdd.control.DbService;
import ch.unibe.tdddemo.tdd.entity.EmploymentDTO;

@RestController
public class Controller {
  DbService service;

  public Controller(DbService service) {
    this.service = service;
  }

  public List<EmploymentDTO> getEmploymentByGuid(String guid) throws NoResultFoundException {
    List<EmploymentDTO> employment = service.getEmployment(guid);
    if (employment.isEmpty()) {
      throw new NoResultFoundException();
    } else {
      return employment;
    }
  }
}
