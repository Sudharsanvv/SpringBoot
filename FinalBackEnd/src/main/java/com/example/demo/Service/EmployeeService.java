package com.example.demo.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employees;
import com.example.demo.Repository.EmployeeRepository;

import jakarta.transaction.Transactional;
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
		public Page<Employees> SortingAndPaging(int page,int size,String field){
			Pageable paging=PageRequest.of(page, size).withSort(Sort.by(field));
			return employeeRepository.findAll(paging);
		}
		public Page<Employees> Paging(int CurrentPage,int itemsPerPage){
			Pageable paging=PageRequest.of(CurrentPage,itemsPerPage);
			return employeeRepository.findAll(paging);
		}
		public List<Employees> sortBookings(String name) {
			return employeeRepository.findAll(Sort.by(name));

		}
		public Page<Employees> pagingBooking(int offset, int pageSize) {
			Pageable paging = PageRequest.of(offset, pageSize);
			return employeeRepository.findAll(paging);
		}

		public Page<Employees>pagingAndSorting(int offset,int pageSize,String field)
		{
			Pageable paging = PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		     return employeeRepository.findAll(paging);
		}
		public List<Employees> fetchPositionByPrefix(String prefix) {
			return employeeRepository.findByNameStartingWith(prefix);
		}

		public List<Employees> fetchPositionBySuffix(String suffix) {
			return employeeRepository.findByNameEndingWith(suffix);
		}

		public List<Employees> getEmployeesByPosition(String position, String name) {
			return employeeRepository.getEmployeesByPosition(position, name);
		}

		public List<Employees> fetchEmployeesByPosition(String position) {
			return employeeRepository.findAllByPosition(position);
		}
		
		@Transactional
		public int deleteEmployeesByName(String name) {
			return employeeRepository.deleteEmployeesByName(name);
		}

		@Transactional
		public int updateEmployeesByName(String position, String name) {
			return employeeRepository.updateEmployeesByName(position, name);
		}


}
