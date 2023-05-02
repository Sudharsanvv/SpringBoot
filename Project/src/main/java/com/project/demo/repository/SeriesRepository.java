package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.model.Series;

@Repository
	public interface SeriesRepository extends JpaRepository<Series,Integer>{

	}

