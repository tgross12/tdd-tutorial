package ch.unibe.tdddemo.tdd.control;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

import ch.unibe.tdddemo.tdd.control.DbService;
import ch.unibe.tdddemo.tdd.entity.EmploymentDTO;

@SpringBootTest
@Transactional
@Sql(scripts = "/testdata.sql")
public class DbServiceTest {

  @Autowired private DbService service;

  @Test
  public void findsEmploymentdataIfExistsTest() {
    // WHEN
    List<EmploymentDTO> employmentData = service.getEmployment("testguid");
    // THEN
    assertThat(employmentData).hasSize(1);
    assertThat(employmentData.get(0)).hasFieldOrPropertyWithValue("firstName", "Test-Firstname");
    assertThat(employmentData.get(0)).hasFieldOrPropertyWithValue("departmentName", "Test-Dept");
  }

  @Test
  public void noEmploymentdataFoundIfNotExistsTest() {
    // WHEN
    List<EmploymentDTO> employmentData = service.getEmployment("non existing guid");
    // THEN
    assertThat(employmentData).hasSize(0);
  }
}
