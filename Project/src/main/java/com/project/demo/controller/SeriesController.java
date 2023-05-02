package com.project.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Series;
import com.project.demo.service.SeriesService;

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

}