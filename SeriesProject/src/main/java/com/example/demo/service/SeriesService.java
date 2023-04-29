package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	public List<Series> sorting(String name) {
		// TODO Auto-generated method stub
		return studsRepository.findAll(Sort.by(name).descending());
	}
	
	public List<Series> page(int num, int size) {
		Page<Series> p=studsRepository.findAll(PageRequest.of(num, size));
		return p.getContent();
	}

	public List<Series> paginationsorting(int pnum, int psize, String name) {
		// TODO Auto-generated method stub
		Page<Series> p=studsRepository.findAll(PageRequest.of(pnum, psize, Sort.by(name).descending()));
		return p.getContent();
	}
//	public String Login(String un,String password)
//	{
//		Series user=studsRepository.findByname(un);
//		if(user==null)
//		{
//			return"There is No User with this Name!";
//		}
//		else
//		{
//			if( user.getPassword().equals(password))
//			{
//				return "Logged in Successfully!";
//			}
//			else
//			{
//				return "Login Failed";
//			}
//		}
//	}
	

}
