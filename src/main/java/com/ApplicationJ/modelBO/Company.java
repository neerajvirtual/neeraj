package com.ApplicationJ.modelBO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

public class Company {
    private Long compid;
    private String companyName;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Employee> employees;

	public Long getCompid() {
		return compid;
	}

	public void setCompid(Long compid) {
		this.compid = compid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


    
    
}
