package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Employees;

public interface EmployeeRepository extends JpaRepository<Employees,Integer>{
	@Query("SELECT b FROM Employees b WHERE b.position = ?1 AND b.name = ?2")
    public List<Employees> getEmployeesByPosition(String position, String name);

    @Query("SELECT b FROM Employees b WHERE b.position = :position")
    public List<Employees> getEmployeesByPosition(String position);
    List<Employees> findByNameStartingWith(String prefix);
    List<Employees> findByNameEndingWith(String suffix);
    List<Employees> findByPosition(String position);
    @Modifying
    @Query("DELETE FROM Employees b WHERE b.name = ?1")
    public int deleteEmployeesByName(String name);
    @Modifying
    @Query("UPDATE Employees b SET b.position = ?1 WHERE b.name = ?2")
    public int updateEmployeesByName(String position, String name);
	public List<Employees> findAllByPosition(String position);



}
