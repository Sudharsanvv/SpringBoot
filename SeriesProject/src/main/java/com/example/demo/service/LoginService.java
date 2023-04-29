package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Login;

import com.example.demo.repository.LoginRep;

@Service
public class LoginService {
      @Autowired
      private LoginRep loginrep;
      public String Login(String un,String password)
  	{
  		Login user=loginrep.findByusername(un);
  		if(user==null)
  		{
  			return"There is No User with this Name!";
  		}
  		else
  		{
  			if( user.getPassword().equals(password))
  			{
  				return "Logged in Successfully!";
  			}
  			else
  			{
  				return "Incorrect Password";
  			}
  		}
  	}
     public Login Post(Login login)
  	{
  		return loginrep.save(login);
  	}
     public Login Update(Login login)
 	{
 		return loginrep.save(login);
 	}
     
      
}