package com.animals.dog;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Dog")
public class Dog {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	private int count;
	private String name;
	private int weight;
	private  int dogage;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dogadd")
	
	private DogAddress address;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getDogage() {
		return dogage;
	}
	public void setDogage(int dogage) {
		this.dogage = dogage;
	}
	public DogAddress getAddress() {
		return address;
	}
	public void setAddress(DogAddress address) {
		this.address = address;
	}
	
	
	
	

}
