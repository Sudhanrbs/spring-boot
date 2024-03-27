package com.animals.dogcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animals.dog.Dog;
import com.animals.dogrepository.Dogrepository;
import com.animals.dogservice.DogService;




@RestController
@RequestMapping("/animal")
public class Dogcontroller {
	
	@Autowired
	Dogrepository dogrepo;
	
	@PostMapping("/adddogdata")
	public Dog adddogdata(@RequestBody Dog dog) {
		Dog a = dogrepo.saveAndFlush(dog);
		return a;
	}
    @GetMapping("/getdog")
	
	public List<Dog> getcatdata() 
	{
		List<Dog> a = dogrepo.findAll();
		return a;
	}
    
    @GetMapping("/getDog/{id}")
   public Dog getdogid(@PathVariable int id)
   {
    	return dogrepo.findById(id).get();
   }
    @PostMapping("/updatedog/{id}")
    public Dog updatedog(@RequestBody Dog dog,@PathVariable int id) 
    {
       Dog a = dogrepo.findById(id).get();
       a.setName(dog.getName());
       a.setWeight(dog.getWeight());
       a.setDogage(dog.getDogage());
       dogrepo.save(a);
	return a;
             
    }
    
    @GetMapping("/Dogdelete/{id}")
    public String deleteid(@PathVariable int id)
    {
    	dogrepo.deleteById(id);
        return "deleted";
    }
    
   
     
     @GetMapping("/change/{id}")
     public ResponseEntity<?> getdog(@PathVariable int id)
     {
      dogrepo.findById(id);
     return ResponseEntity.status(HttpStatus.OK).body("Deleted");	
     }
     
     @Autowired
     DogService dogservicerepo;
     @PostMapping("/do")
     public ResponseEntity<?> createDogService(@RequestBody Dog dog) {
    	 	Dog d = dogservicerepo.createUser( dog);
         return ResponseEntity.status(HttpStatus.OK).body(d);
     }
     
     
}
