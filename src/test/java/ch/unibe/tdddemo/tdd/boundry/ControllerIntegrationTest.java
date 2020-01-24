package ch.unibe.tdddemo.tdd.boundry;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Sql(scripts = "/testdata.sql")
@Transactional
public class ControllerIntegrationTest {

  @Autowired private TestRestTemplate restTemplate;

  @LocalServerPort private int port;

  @Test
  public void getUnisportByPersonalNrIntegrationTest() throws Exception {
    String url = "http://localhost:" + port + "/employmentbyguid?guid=cbtestguid";
    ResponseEntity result = restTemplate.getForEntity(url, String.class);
    assertThat(result.getBody()).isEqualTo("test");
  }

  @Test
  public void getUnisportByShibIdExceptionTest() throws Exception {
    String url = "http://localhost:" + port + "/employmentbyguid?guid=notexistingguid";
    ResponseEntity result = restTemplate.getForEntity(url, String.class);
    assertThat(result.toString()).contains("Not found");
  }
}
