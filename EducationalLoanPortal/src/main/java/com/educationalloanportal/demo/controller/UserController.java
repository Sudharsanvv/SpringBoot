package com.educationalloanportal.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.educationalloanportal.demo.model.LoanApplicationModel;
import com.educationalloanportal.demo.model.LoginModel;
import com.educationalloanportal.demo.model.UserModel;
import com.educationalloanportal.demo.service.LoanApplicationModelService;
import com.educationalloanportal.demo.service.UserService;

@RestController
//@RequestMapping("/user")
@CrossOrigin
public class UserController 
{
	@Autowired
	UserService uSer;
	@Autowired
	LoanApplicationModelService lamService;
	 @GetMapping("/fetch")
     public List<UserModel> getUserDetails()
     {
  	   List<UserModel> userList = uSer.getUserDetails();
  	   return userList;
     }
	@PostMapping("/userlogin")
	public String validateUser(@RequestBody LoginModel logindata )
	{
		return uSer.validateUser(logindata.getEmail(),logindata.getPassword());	
	}
	@PostMapping("/usersignup")
	public UserModel newUser(@RequestBody UserModel user)
	{
		return uSer.newUser(user);
	}
	@GetMapping(value="/getloan/{loanId}")
    public  LoanApplicationModel getLoan(@PathVariable int loanId)
    {
    	return uSer.getLoan(loanId);
    }
	@GetMapping("/getprofile/{id}")
	public UserModel getProfile(@PathVariable int id)
	{
		return uSer.getProfile(id);
	}
}