package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Person;
import com.example.demo.Service.AddressPersonService;

@RestController
public class AddressPersonController 
{
   @Autowired
   AddressPersonService perService;
   @GetMapping("/getAllPersons")
   public List<Person> fetchAllPersons()
   {
	  return perService.fetchAllPersons();
   }
   @PostMapping("/saveAlldata")
   public Person savePersons(@RequestBody Person p)
   {
	   return perService.savePersons(p);
   }
}