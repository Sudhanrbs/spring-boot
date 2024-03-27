package com.animals.dogrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.animals.dog.Dog;

public interface Dogrepository extends JpaRepository<Dog, Integer> {

@Query("select u from Dog u where u.name=?1")
Dog getdog(String name);
	
}
