package com.educationalloanportal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educationalloanportal.demo.model.LoanApplicationModel;
import com.educationalloanportal.demo.repository.LoanApplicationModelRepository;


@Service
public class AdminService 
{
    @Autowired
    LoanApplicationModelRepository loanApp;
    public List<LoanApplicationModel> getAdmin() 
	{
		
    	return loanApp.findAll();
	}
	public LoanApplicationModel saveDeatils(LoanApplicationModel lm) 
	{
		
		return loanApp.save(lm);
	}
	
    
}