package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Audience;
import com.example.demo.repository.AudienceRepository;

import java.util.List;


@Service
public class AudienceService 
{
	@Autowired
   AudienceRepository personRepo;
		public List<Audience>fetchAllAudience()
		{
			return personRepo.findAll();
		}
		public Audience saveAudience(Audience p)
		{
			return personRepo.save(p);
		}
}