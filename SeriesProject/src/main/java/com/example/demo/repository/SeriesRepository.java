package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Integer>{
	//positional parameter -> ? order match
		@Query("select s from Series s where s.hero=?1 and s.name=?2")
		public List<Series> getSeriesByHero(String hero,String name);
		
		 //named parameter -> just name
		 @Query("select s from Series s where s.hero=:hero")
		 public List<Series> getSeriesByHero(String hero);
		

	   List<Series>findByHeroStartingWith(String prefix);
	   List<Series>findByHeroEndingWith(String suffix);
	   List<Series>findByHero(String hero);
		
		@Modifying
		@Query("delete  from Series s where s.name=?1" )
		public int deleteSeriesByHero(String hero);
		
		@Modifying
		@Query("update Series s set s.hero=?1 where s.name=?2" )
		public int updateSeriesByHero(String hero,String name);

		@Query(value="select * from Series s  where  hero= ?1", nativeQuery=true)
		 	public List<Series> fetchSeriesByHero(String hero);


}
