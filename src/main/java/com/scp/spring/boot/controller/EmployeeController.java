package com.scp.spring.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scp.spring.boot.entity.Employee;
import com.scp.spring.boot.service.EmployeeService;

/**
 * GET  -- http://localhost:8080/myapp/test   -- to check app is running or not
 * POST --http://localhost:8080/myapp/emps/save  -- to get all emps
 * GET  --http://localhost:8080/myapp/emps/get/10 -- to get emp with id 10 
 * DELETE --http://localhost:8080/myapp/emps/delete/10 -- -- to delete emp with id 10
 * PUT --http://localhost:8080/myapp/emps/update -- update the emp
 * 
 * @author Yogymax
 *
 */

@RestController
@RequestMapping("/myapp")
public class EmployeeController {

	static {
		System.out.println("Emp controller loaded..");
	}
	
	
	@Autowired
	EmployeeService empService;

	@RequestMapping("/test")
	public String homepage() {
		return "Test Method -- Spring Boot ";
	}

	@GetMapping("/emps")
	public List<Employee> getAllEmps() {
		return empService.findAll();
	}

	@GetMapping("/emps/get/{id}")
	public Optional<Employee> getEmp(@PathVariable(value = "id") Long empId) {
		return empService.findById(empId);
	}

	@PostMapping("emps/save")
	public Employee saveEmp(@RequestBody Employee emp) {
		return empService.save(emp);
	}

	@DeleteMapping("/emps/delete/{id}")
	public List<Employee> deleteEmp(@PathVariable(value = "id") Long empId) {
		empService.deleteById(empId);
		return getAllEmps();
	}

	@PutMapping("emps/update")
	public Employee updateEmp(@RequestBody Employee updateEmp) {

		Optional<Employee> emp = empService.findById(updateEmp.getEmpId());
		
		if(emp.isPresent()) {
			return empService.save(updateEmp);	
		}
		return null;
	}
	
}

/**
 * Remarks
 * 
 * @GetMapping("/emp") annotation is a short form of
 * @RequestMapping(value="/emp", method=RequestMethod.GET)
 * 
 * @PostMapping("/emp") annotation is a short form of
 * @RequestMapping(value="/emp", method=RequestMethod.POST)
 * 
 * 
 * Optional class is added in java8 -- purpose is to provide a type-level solution for
 * representing optional values instead of using null references meaning -- if no employee found
 * with given id, it will return empty employee but not null
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
*/
