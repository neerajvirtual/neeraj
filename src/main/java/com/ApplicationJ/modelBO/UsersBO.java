package com.ApplicationJ.modelBO;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class UsersBO{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "status_id" , nullable=false)
	private StatusBO status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StatusBO getStatus() {
		return status;
	}

	public void setStatus(StatusBO status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UsersBO [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status + "]";
	}
	
}