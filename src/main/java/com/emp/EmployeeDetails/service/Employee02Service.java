package com.emp.EmployeeDetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.EmployeeDetails.Exception.Employee02IdNotFoundException;
import com.emp.EmployeeDetails.dao.Employee02Dao;
import com.emp.EmployeeDetails.dto.Employee02;

@Service
public class Employee02Service
{
	private Employee02Dao employee02Dao;

	public Employee02Service(Employee02Dao employee02Dao) {
		super();
		this.employee02Dao = employee02Dao;
	}
	
	public Employee02 createEmp(Employee02 employee02)
	{
		return employee02Dao.create(employee02);
	}
	public Employee02 updateEmp(Employee02 employee02)
	{
		return employee02Dao.update(employee02);
	}
	
	public List<Employee02> retriveAllEmp()
	{
		return employee02Dao.retriveAll();
	}
	
	public Employee02 servicefindId(long id)
	{
		if(employee02Dao==null)
			throw new Employee02IdNotFoundException("id  " +id);
		return employee02Dao.daoFindId(id);
	}
	
	public void servicedeleteTheId(long id)
	{
		if(employee02Dao==null)
			throw new Employee02IdNotFoundException("id  " +id);
		employee02Dao.daodeleteId(id);
	}
	
//	public ResponseEntity<Employee02ResponseStructure<Employee02>> createEmp(Employee02 employee02)
//	{
//			Employee02ResponseStructure<Employee02> emp=new Employee02ResponseStructure<Employee02>();
//			emp.setBody(employee02Dao.create(employee02));
//			emp.setMsg("Employee Added Successfully");
//			emp.setCode(HttpStatus.CREATED.value());
//		return new ResponseEntity<Employee02ResponseStructure<Employee02>>(emp, HttpStatus.CREATED) ;
//	}
//	public ResponseEntity<Employee02ResponseStructure<Employee02>> updateEmp(Employee02 employee02)
//	{
//		Employee02ResponseStructure<Employee02> emp=new Employee02ResponseStructure<>();
//		emp.setBody(employee02Dao.update(employee02));
//		emp.setMsg("Employee updated Successfully");
//		emp.setCode(HttpStatus.CREATED.value());
//		return new ResponseEntity<Employee02ResponseStructure<Employee02>>(emp, HttpStatus.CREATED) ;
//	}
//	
//	public ResponseEntity<Employee02ResponseStructure<List<Employee02>>> retriveAllEmp()
//	{
//		Employee02ResponseStructure<List<Employee02>> emp=new Employee02ResponseStructure<List<Employee02>>();
//		emp.setBody(employee02Dao.retriveAll());
//		emp.setMsg("Employees get All data");
//		emp.setCode(HttpStatus.CREATED.value());
//		return new ResponseEntity<Employee02ResponseStructure<List<Employee02>>>(emp,HttpStatus.FOUND);
//	}
//	
//	public ResponseEntity<Employee02ResponseStructure<Employee02>> servicefindId(long id)
//	{
//		Employee02ResponseStructure<Employee02> emp=new Employee02ResponseStructure<Employee02>();
//		emp.setBody(employee02Dao.daoFindId(id));
//		emp.setMsg("Employee get id Successfully");
//		emp.setCode(HttpStatus.CREATED.value());
//		if(employee02Dao==null)
//			throw new Employee02IdNotFoundException("id  " +id);
//		return new ResponseEntity<Employee02ResponseStructure<Employee02>>(emp,HttpStatus.FOUND);
//	}
//	
//	public ResponseEntity<Void> servicedeleteTheId(long id)
//	{
//		Employee02ResponseStructure<Employee02> emp=new Employee02ResponseStructure<Employee02>();
//		//emp.setBody(employee02Dao.daodeleteId(id));
//		emp.setMsg("Employee deleted Successfully");
//		emp.setCode(HttpStatus.CREATED.value());
//		employee02Dao.daodeleteId(id);
//		if(employee02Dao==null)
//			throw new Employee02IdNotFoundException("id  " +id);
//		return ResponseEntity.noContent().build();
//	}
}
