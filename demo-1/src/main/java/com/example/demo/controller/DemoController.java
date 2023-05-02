package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	@ResponseBody
	@RequestMapping(value="/message",method=RequestMethod.GET)
	public String welcome()
	{
		return "Welcome";
	}
	@ResponseBody
	@RequestMapping(value="/sendoff",method=RequestMethod.GET)
	public String sendoff()
	{
		return "Sendoff";
	}
}
