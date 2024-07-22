//ActorOperationsController
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsController {
	
	
	@GetMapping("/wish/{name}")
	public  ResponseEntity<String>  showWishMessage(@PathVariable String name){
		return new  ResponseEntity<String>("Good Moring::"+name,HttpStatus.OK);
	}

}
