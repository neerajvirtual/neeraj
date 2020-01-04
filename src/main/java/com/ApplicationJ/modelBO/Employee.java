package com.ApplicationJ.modelBO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private Long empid;
	
	@Column(name="fst_name")
    private String fstName;
	
	@Column(name="lst_name")
    private String lstName;
    
	@Column(name="sal")
    private String sal;

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getFstName() {
		return fstName;
	}

	public void setFstName(String fstName) {
		this.fstName = fstName;
	}

	public String getLstName() {
		return lstName;
	}

	public void setLstName(String lstName) {
		this.lstName = lstName;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @NotFound(action = NotFoundAction.IGNORE)
//    @JoinColumn(name = "compid", nullable = true)
//    private Company company;
	
}
