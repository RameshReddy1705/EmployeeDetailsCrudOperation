package com.emp.EmployeeDetails.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.emp.EmployeeDetails.Exception.Employee02IdNotFoundException;
import com.emp.EmployeeDetails.JpaRepository.Employee02Repository;
import com.emp.EmployeeDetails.JpaRepository.ProjectRepository;
import com.emp.EmployeeDetails.dto.Employee02;
import com.emp.EmployeeDetails.dto.Projects;
import com.emp.EmployeeDetails.service.Employee02Service;

@RestController
@CrossOrigin("*")
public class Employee02Controller
{
	private Employee02Service employee02Service;
	private Employee02Repository employee02Repository;
	private ProjectRepository projectRepository;

	public Employee02Controller(Employee02Service employee02Service, Employee02Repository employee02Repository, ProjectRepository projectRepository) {
		super();
		this.employee02Service = employee02Service;
		this.employee02Repository=employee02Repository;
		this.projectRepository=projectRepository;
	}
	
	@PostMapping("/emp02")
	public Employee02 createEmployee02(@RequestBody Employee02 employee02)
	{
		return employee02Service.createEmp(employee02);	
	}
	@PutMapping("/emp02")
	public Employee02 updateEmployee02(Employee02 employee02)
	{

		return employee02Service.updateEmp(employee02);	
	}
	@GetMapping("/emp02")
	public List<Employee02> retriveAllEmployees()
	{
		return employee02Service.retriveAllEmp();
	}
	
	@GetMapping("/emp02/{id}")
	public Employee02 findByTheId(@PathVariable long id)
	{
		return employee02Service.servicefindId(id);
	}
	@DeleteMapping("emp02/{id}")
	public void  deleteByTheId(@PathVariable long id)
	{
		employee02Service.servicedeleteTheId(id);
	}
	
//	@PostMapping("/emp02")
//	public ResponseEntity<Employee02ResponseStructure<Employee02>> createEmployee02(@RequestBody Employee02 employee02)
//	{
//		return employee02Service.createEmp(employee02);	
//	}
//	@PutMapping("/emp02")
//	public ResponseEntity<Employee02ResponseStructure<Employee02>> updateEmployee02(@RequestBody Employee02 employee02)
//	{
//
//		return employee02Service.updateEmp(employee02);	
//	}
//	@GetMapping("/emp02")
//	public ResponseEntity<Employee02ResponseStructure<List<Employee02>>> retriveAllEmployees()
//	{
//		return employee02Service.retriveAllEmp();
//	}
//	
//	@GetMapping("/emp02/{id}")
//	public ResponseEntity<Employee02ResponseStructure<Employee02>> findByTheId(@PathVariable long id)
//	{
//		return employee02Service.servicefindId(id);
//	}
//	@DeleteMapping("emp02/{id}")
//	public ResponseEntity<Void>  deleteByTheId(@PathVariable long id)
//	{
//		return employee02Service.servicedeleteTheId(id);
//	}
	
	
	//....................................................................................
	@PostMapping("/emp02/{id}/projects")
	public ResponseEntity<Object> createProjects(@PathVariable long id, @RequestBody Projects projects)
	{
		Optional<Employee02> emplOp=employee02Repository.findById(id);
		if(emplOp.isEmpty())
			throw new Employee02IdNotFoundException("id  " +id);
		projects.setEmployee02(emplOp.get());
		Projects projectsaved=projectRepository.save(projects);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(projectsaved.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/emp02/{id}/projects")
	public List<Projects> retriveProjects(@PathVariable long id)
	{
		Optional<Employee02> empl=employee02Repository.findById(id);
		if(empl.isEmpty())
			throw new Employee02IdNotFoundException("id  " +id);
		
		return empl.get().getProjects();
	}
	
	
	
}
