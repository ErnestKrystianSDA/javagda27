package test_project.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Employee {

	
	@Id
	@GeneratedValue
	private long id;
	
	@Transient
	private boolean isOk;
	
	@Column(name="EMP_TYPE") 
	@Enumerated(EnumType.STRING) 
	private EmpType empType;
	@Column(name="HIRE_DATE") 
	@Temporal(TemporalType.TIMESTAMP) 
	private Date hireDate;

}
