package ch.unibe.tdddemo.tdd;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.qlrm.executor.JpaQueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DbService {
  private JpaQueryExecutor queryExecutor = new JpaQueryExecutor();

  @Autowired
  EntityManager em;

  public List<EmploymentDTO> getEmployment(String testguid) {
    List<EmploymentDTO> employmentDTOS = queryExecutor.executeSelect(em,
        EmploymentDTO.class,
        "query.sql",
        testguid);
    return employmentDTOS;
  }
}
