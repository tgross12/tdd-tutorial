package ch.unibe.tdddemo.tdd.control;

import java.util.List;

import javax.persistence.EntityManager;

import org.qlrm.executor.JpaQueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.unibe.tdddemo.tdd.entity.EmploymentDTO;

@Repository
public class DbService {
  private JpaQueryExecutor queryExecutor = new JpaQueryExecutor();

  @Autowired
  EntityManager em;

  public List<EmploymentDTO> getEmployment(String guid) {
    return queryExecutor.executeSelect(em,
        EmploymentDTO.class,
        "query.sql",
        guid);
  }
}
