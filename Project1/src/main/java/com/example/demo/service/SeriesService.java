package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Series;
import com.example.demo.repository.SeriesRepository;

@Service
public class SeriesService {
	@Autowired
	SeriesRepository studsRepository;
	public List<Series> getAllSeriess(){
	List<Series> studsList = studsRepository.findAll();
	return studsList;
	}
	public Series saveSeries(Series s)
	{
		Series obj = studsRepository.save(s);
		
		return obj;
	}
	public Series updateSeries(Series s)
	{
		Series obj = studsRepository.save(s);
		
		return obj;
	}
	public void deleteSeries(int season)
	{
		studsRepository.deleteById(season);
	}
	

}
