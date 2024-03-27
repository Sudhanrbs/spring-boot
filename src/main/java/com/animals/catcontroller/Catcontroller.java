package com.animals.catcontroller;

import java.util.List;

//import org.hibernate.mapping.List;
//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.animals.cat.Cat;
import com.animals.catrepository.Catrepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

 

@RestController
@RequestMapping("/animal")
public class Catcontroller {
	
	@Autowired
	Catrepository catrepo;
	@PostMapping("/addcat")
	public Cat addcatdata(@RequestBody Cat cat) 
	{
		Cat b = catrepo.saveAndFlush(cat);
		return b;
	}
	
	@GetMapping("/get")
	
	public List<Cat> getcatdata() 
	{
		List<Cat> a = catrepo.findAll();
		return a;
	}
	
	@GetMapping("/getcat/{id}")
	public Cat getcatdataid(@PathVariable int id) {
		return catrepo.findById(id).get();
		
	}
	@PostMapping("/update/{id}")
	public Cat updatecatdata(@RequestBody Cat cat,@PathVariable int id) {
		Cat a = catrepo.findById(id).get();
		a.setName(cat.getName());
		a.setWeight(cat.getWeight());
		return catrepo.save(a);
	}
	@GetMapping("/delete/{id}")
	public void deletecatid(@PathVariable int id) {
		 catrepo.deleteById(id);
		
		
	}
	@GetMapping("/response/{id}")
	public ResponseEntity<?> response(@PathVariable int id)
	{
		catrepo.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body("deleted");
		
	}
	
	
	
	

}
