package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Audience;
import com.example.demo.service.AudienceService;


import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AudienceController
{
	@Autowired
     AudienceService personserv;
	@GetMapping("/getAllAudience")
		public List<Audience>fetchAllAudience()
		{
			return personserv.fetchAllAudience();
    	}
}