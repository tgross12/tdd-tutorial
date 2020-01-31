package ch.unibe.tdddemo.tdd.boundry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ControllerIntegrationTest {

  @Autowired private TestRestTemplate restTemplate;

  @LocalServerPort private int port;

  @Test
  public void getUnisportByPersonalNrIntegrationTest() throws Exception {
    String url = "http://localhost:" + port + "/employmentbyguid?guid=cbtestguid";
    ResponseEntity result = restTemplate.getForEntity(url, String.class);
    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody())
        .isEqualTo(
            "[{\"firstName\":\"Camillo\",\"lastName\":\"Berneri\",\"departmentName\":\"God Dept\",\"roleTypeName\":\"Employee\",\"beginDate\":\"2010-10-10\",\"endDate\":\"2015-10-17\"},{\"firstName\":\"Camillo\",\"lastName\":\"Berneri\",\"departmentName\":\"God Dept\",\"roleTypeName\":\"Lecturer\",\"beginDate\":\"2008-08-17\",\"endDate\":\"2020-12-01\"}]");
  }

  @Test
  public void getUnisportByShibIdExceptionTest() throws Exception {
    String url = "http://localhost:" + port + "/employmentbyguid?guid=notexistingguid";
    ResponseEntity result = restTemplate.getForEntity(url, String.class);
    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(result.toString()).contains("Not Found");
  }
}
