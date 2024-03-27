package com.animals.catrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.animals.cat.Cat;

public interface Catrepository extends JpaRepository<Cat, Integer> {

}
