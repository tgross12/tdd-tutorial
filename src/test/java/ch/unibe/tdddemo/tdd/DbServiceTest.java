package ch.unibe.tdddemo.tdd;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class DbServiceTest {

  @Autowired
  private DbService service;

  @Test
  public void findsEmploymentdataIfExistsTest() {
    //WHEN
    List<EmploymentDTO> employmentData = service.getEmployment("testguid");
    //THEN
    assertThat(employmentData).hasSize(1);
    assertThat(employmentData.get(0)).hasFieldOrPropertyWithValue("firstName", "Test-Firstname");
  }

  @Test
  public void noEmploymentdataFoundIfNotExistsTest() {
    //WHEN
    List<EmploymentDTO> employmentData = service.getEmployment("non existing guid");
    //THEN
    assertThat(employmentData).hasSize(0);
  }

}
