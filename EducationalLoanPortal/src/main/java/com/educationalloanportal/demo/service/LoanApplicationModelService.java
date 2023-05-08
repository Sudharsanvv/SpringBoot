package com.educationalloanportal.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educationalloanportal.demo.model.LoanApplicationModel;
//import com.educationalloanportal.demo.model.UserModel;
import com.educationalloanportal.demo.repository.LoanApplicationModelRepository;

@Service
public class LoanApplicationModelService
{
    @Autowired
    LoanApplicationModelRepository lamRep;
	public List<LoanApplicationModel> fetchLoan() 
	{
		
		return lamRep.findAll();
	}
	public  LoanApplicationModel updateLoan(LoanApplicationModel l, int loanId)
	{
		
		Optional<LoanApplicationModel> optional= lamRep.findById(loanId);
		LoanApplicationModel obj=null;
   		if(optional.isPresent())
   		{
   			obj=optional.get();
   		    lamRep.save(l);
   		}
   		return obj;
	}
	public void deleteLoan(int loanId) 
	{
		
		lamRep.deleteById(loanId);
	}
	public LoanApplicationModel saveLoan(LoanApplicationModel m)
	{
		return lamRep.save(m);
	}

}