package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Audience;

@Repository
public interface AudienceRepository extends JpaRepository<Audience,Integer> {

}