package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Registration;
import com.example.demo.service.userRegistrationService;

@RestController
public class userRegistrationController
{
	@Autowired
    userRegistrationService usrRegsitrationService;
    @PostMapping("/registereduser")
    public Registration saveRegistration(@RequestBody Registration r)
    {
  	  return usrRegsitrationService.saveRegistration(r);
    }
    @GetMapping("/fetchalldata")
    public List<Registration> getAllUsers()
    {
    	List<Registration> regList = usrRegsitrationService.getAllUsers();
    	return regList;
    }
}