package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Series;
import com.example.demo.service.SeriesService;



@RestController
public  class SeriesController {
	@Autowired
	SeriesService studsService;
	@GetMapping("/out")
	public List<Series> getAllSeriess()
	{
		List<Series> studsList = studsService.getAllSeriess();
		return studsList;
	}
	//http://localhost:8080/saveStudent
	@PostMapping(value="/saveSeries")
	public Series saveSeries(@RequestBody Series s)
	{
		return studsService.saveSeries(s);
	}
	@PutMapping(value="/updateSeries")
	public Series updateSeries(@RequestBody Series s)
	{
		return studsService.saveSeries(s);
	}
	@DeleteMapping(value="/deleteSeries/{sno}")
	public void deleteSeries(@PathVariable("sno") int season)
	{
	          studsService.deleteSeries(season);
	}
	//sorting
		@GetMapping("/sort/{name}")
		public List<Series> sorting(@PathVariable("name")String name)
		{
			 return studsService.sorting(name);
		}
		
		//pagination
		@GetMapping("/page/{pnum}/{psize}")
		public List<Series> page(@PathVariable("pnum")int num,@PathVariable("psize")int size)
		{
			return studsService.page(num,size);
		}
		
		//pagination sorting
		@GetMapping("/paginationsort/{pnum}/{psize}/{name}")
		public List<Series> paginationsorting(@PathVariable("pnum")int pnum,@PathVariable("psize")int psize,@PathVariable("name")String name)
		{
			return studsService.paginationsorting(pnum,psize,name);
		}

}