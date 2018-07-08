package com.demo.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "student")
public class Student {


	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private long studentId;

	@Column(name = "student_name", nullable = false, length = 100)
	private String studentName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_address", referencedColumnName="address_id")
	private Address studentAddress;

	@Column(name = "date_time")
	@DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
	//@Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", dateTime=" + dateTime + "]";
	}	
	
	

}
