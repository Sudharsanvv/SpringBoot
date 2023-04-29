package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
 
import com.example.demo.service.LoginService;
@RestController
@RequestMapping("/log")
public class LoginController {
	@Autowired
	private LoginService loginservice;
	@GetMapping("/login")
	public String Login(@RequestBody Login ph)
	{
		
		return loginservice.Login(ph.getUsername(), ph.getPassword());
	}
	@PostMapping("/add")
	public String add(@RequestBody Login student)
	{
		loginservice.Post(student);
		return "Successfully Added";
	}
	@PutMapping("/update")
	public String update(@RequestBody Login student)
	{
		loginservice.Update(student);
		return "Successfully Updated";
	}

}