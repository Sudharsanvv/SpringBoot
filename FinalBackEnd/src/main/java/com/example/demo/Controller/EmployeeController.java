package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import org.hibernate.grammars.hql.HqlParser.SortDirectionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employees;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmployeeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;
    @Tag(name="getAllFetchDetails",description="getAll")

    @GetMapping(value="/get")
    public List<Employees> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @GetMapping(value="/{currentPage}/{itemsPerPage}/{sortBy}/{sortOrder}")
    public Page<Employees> getData(@PathVariable(value="currentPage") int page,
                                              @PathVariable(value= "itemsPerPage") int size,
                                              @PathVariable(value= "sortBy") String field,
                                              @PathVariable(value= "sortOrder") String direction) {
    	Pageable paging;
   if(direction.equals("asc")) {
   paging=PageRequest.of(page-1, size).withSort(Sort.by(field));
   }
   else {
	   paging=PageRequest.of(page-1, size).withSort(Sort.by(field).descending());       
   }
  return  employeeRepository.findAll(paging);
    }	
    @PostMapping
    public Employees createEmployee(@RequestBody Employees employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Employees>> getEmployeeById(@PathVariable  int id){
        Optional<Employees> employee = employeeRepository.findById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
	public Employees updateBookDetails(@RequestBody Employees b)
	{
		System.out.println("Changes Made Have Been Successfully Updated");
		return employeeRepository.save(b);		
	}
    @DeleteMapping("{id}")
	public String deleteDetails(@PathVariable int id)
	{
		employeeRepository.deleteById(id);
		return "Id : "+id+" is deleted";
	}
    @DeleteMapping
    public String deleteAllDetails()
    {
    	employeeRepository.deleteAll();
    	return "All employees deleted";
    }
    @GetMapping("/sortbooking/{name}")
    public List<Employees> sortBookings(@PathVariable String name)
    {
    	return employeeService.sortBookings(name);
    }

    //paging
    @GetMapping("/pagingbooking/{offset}/{pageSize}")
    public Page<Employees> pagingBooking(@PathVariable int offset,@PathVariable int pageSize)
    {
    	return employeeService.pagingBooking(offset,pageSize);
    }

    	
    @GetMapping("/pagingAndSortingbooking/{offset}/{pageSize}/{field}")

    public Page<Employees> pagingAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field) 
    {
    	return employeeService.pagingAndSorting(offset, pageSize, field);
    }
    //http://localhost:9080/fetchStudentsByNamePrefix?prefix=a
    @GetMapping("getTeamPre/{prefix}")
    public List<Employees> fetchByPrefix(@PathVariable("prefix") String prefix)
    {
    	return employeeService.fetchPositionByPrefix(prefix);
    }
    @GetMapping("/getSuffix/{suffix}")
    public List<Employees> fetchBySuffix(@PathVariable("suffix") String suffix)
    {
    	return employeeService.fetchPositionBySuffix(suffix);
    }
    //query
    @GetMapping("/fetchByBooking/{position}/{name}")
    public List<Employees> getEmployeesByPosition(@PathVariable String position,@PathVariable String name)
    {
    	return employeeService.getEmployeesByPosition(position,name);
    }
    @DeleteMapping("/deleteEmployeesByName/{name}")
    public String deleteEmployeesByName(@PathVariable String name)
    {
    	int result=employeeService.deleteEmployeesByName(name);
    	if(result>0)
    		return "Booking record deleted";
    	else
    		return "Problem occured while deleting";
    	
    }
    @PutMapping("/updateByName/{position}/{name}")
    public String updateEmployeesByName(@PathVariable String position,@PathVariable String name)
    {
    	int result=employeeService.updateEmployeesByName(position,name);
    	if(result>0)
    		return "Booking record updated";
    	else
    		return "Problem occured while updating";
    }
    
    @GetMapping("/nquery/{position}") 
    public List<Employees> fetchEmployeesByPosition(@PathVariable("position") String position)
    {
    	return employeeService.fetchEmployeesByPosition(position);
    }
}