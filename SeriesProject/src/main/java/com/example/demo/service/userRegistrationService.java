package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Registration;
import com.example.demo.repository.userRegistrationRepository;



@Service
public class userRegistrationService 
{
    @Autowired
    userRegistrationRepository usrRegistrationRepository;
	public Registration saveRegistration(Registration r) 
	{
		return usrRegistrationRepository.save(r);
	}
	public List<Registration> getAllUsers() 
	{
		 List<Registration> regList = usrRegistrationRepository.findAll();
	      return regList;
	}
}