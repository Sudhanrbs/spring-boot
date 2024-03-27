package com.animals.dogserviceimpliment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animals.dog.Dog;
import com.animals.dogrepository.Dogrepository;
import com.animals.dogservice.DogService;
@Service
public class DogServiceImpliment implements DogService {
  
	@Autowired
	Dogrepository dogrepo;
	public Dog createUser(Dog d)
	{
		return dogrepo.save(d);
	}
}
