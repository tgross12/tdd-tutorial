package ch.unibe.tdddemo.tdd.boundry;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import ch.unibe.tdddemo.tdd.control.DbService;
import ch.unibe.tdddemo.tdd.entity.EmploymentDTO;

class ControllerTest {

  @Mock DbService service;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void resultGiven() {
    EmploymentDTO employmentDTO =
        new EmploymentDTO(
            "testfistname",
            "testlastname",
            "testdept",
            "testroletype",
            Date.valueOf(LocalDate.now()),
            Date.valueOf(LocalDate.now()));
    List<EmploymentDTO> list = new ArrayList<>();
    list.add(employmentDTO);
    doReturn(list).when(service).getEmployment(any());

    Controller controller = new Controller(service);

    List<EmploymentDTO> result = controller.getEmploymentByGuid("testguid");

    assertThat(result).hasSize(1);
  }

  @Test
  void noResultFoundThrows() {
    List<EmploymentDTO> list = new ArrayList<>();
    doReturn(list).when(service).getEmployment(any());

    Controller controller = new Controller(service);

    Throwable thrown =
        catchThrowable(
            () -> {
              List<EmploymentDTO> result = controller.getEmploymentByGuid("testguid");
            });
    assertThat(thrown).isInstanceOf(NoResultFoundException.class);
  }
}
