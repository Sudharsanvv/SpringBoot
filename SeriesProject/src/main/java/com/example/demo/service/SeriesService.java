package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Series> fetchHeroByPrefix(String prefix)
	{
		return studsRepository.findByHeroStartingWith(prefix);
	}
	public List<Series> fetchHeroBySuffix(String suffix)
	{
		return studsRepository.findByHeroEndingWith(suffix);
	}
	
	public List<Series> getSeriesByHero(String hero,String name)
	{
		return studsRepository.getSeriesByHero(hero,name);
	}
	
@Transactional
public int deleteSeriesByHero(String hero)
{
	return studsRepository.deleteSeriesByHero(hero);
}

@Transactional
public int updateSeriesByHero(String hero,String name)
{
	return studsRepository.updateSeriesByHero(hero,name);
}
	
public List<Series> fetchSeriesByHero(String hero)
{
	return studsRepository.fetchSeriesByHero(hero);
}

	

}
