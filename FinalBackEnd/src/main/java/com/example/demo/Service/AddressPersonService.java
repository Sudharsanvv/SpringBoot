package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Person;
import com.example.demo.Repository.PersonRepository;

@Service
public class AddressPersonService 
{
   @Autowired
   PersonRepository perRep;
  
   
 
   public List<Person>fetchAllPersons()
   {
	   return perRep.findAll();
	   
   }
 
   public Person savePersons(Person p)
   {
	   return perRep.save(p);
   }
}