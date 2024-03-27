package com.animals.cat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cat")
public class Cat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int count;
	private String name;
	private int weight;
	private  int catage;
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
	public int getCatage() {
		return catage;
	}
	public void setCatage(int catage) {
		this.catage = catage;
	}
	
	
	

}
