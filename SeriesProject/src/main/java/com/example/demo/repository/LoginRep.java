package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Login;
@Repository

public interface LoginRep extends JpaRepository<Login,Integer> {
	Login findByusername(String username);

}