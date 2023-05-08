package com.educationalloanportal.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educationalloanportal.demo.model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer>
{
	UserModel findByEmail(String email); 
}