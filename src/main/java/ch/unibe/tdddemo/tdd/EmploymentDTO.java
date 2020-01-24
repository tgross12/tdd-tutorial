package ch.unibe.tdddemo.tdd;

import java.sql.Date;
import java.time.LocalDate;

public class EmploymentDTO {
  private final String firstName;
  private final String lastName;
  private final String departmentName;
  private final String roleTypeName;
  private final Date beginDate;
  private final Date endDate;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public EmploymentDTO(String firstName, String lastName, String departmentName, String roleTypeName, Date beginDate, Date endDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentName = departmentName;
    this.roleTypeName = roleTypeName;
    this.beginDate = beginDate;
    this.endDate = endDate;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public String getRoleTypeName() {
    return roleTypeName;
  }

  public Date getBeginDate() {
    return beginDate;
  }

  public Date getEndDate() {
    return endDate;
  }
}
