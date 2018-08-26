package com.ApplicationJ.modelBO;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class FoodBO{

	@Id
	@Column(name = "food_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer food_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	@Column(name="status")
	private boolean status;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "food_type_id" , nullable=false, insertable=false, updatable=false)
	private FoodTypeBO food_type;
	
	@Column(name = "type_id")
	private Integer type_id;

	public Integer getFood_id() {
		return food_id;
	}

	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public FoodTypeBO getFood_type() {
		return food_type;
	}

	public void setFood_type(FoodTypeBO food_type) {
		this.food_type = food_type;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	@Override
	public String toString() {
		return "FoodBO [food_id=" + food_id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", food_type=" + food_type + ", type_id=" + type_id + "]";
	}

	
	
}