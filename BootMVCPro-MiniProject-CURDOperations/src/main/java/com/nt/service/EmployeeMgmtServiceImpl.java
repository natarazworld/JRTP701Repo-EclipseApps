package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private  IEmployeeRepository  empRepo;

	@Override
	public Iterable<Employee> showAllEmployees() {
				return empRepo.findAll();
	}
	
	@Override
	public String registerEmployee(Employee emp) {
	    int idVal=empRepo.save(emp).getEmpno();
		return "Employee is saved with id Value:"+idVal;
	}

	@Override
	public Employee findEmployeeByNo(int no) {
		return empRepo.findById(no).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
	}
	
   @Override
   	public String updateEmployee(Employee emp) {
   		//Load object
	    Optional<Employee> opt=empRepo.findById(emp.getEmpno());
	    if(opt.isPresent()) {
	    	//update the object
	    	empRepo.save(emp);
	    	return "Employee details are updated";
	    }
   		return "Employee is not found for updation";
   	}	
   
   @Override
public String removeEmployeeById(int id) {
		//Load object
	    Optional<Employee> opt=empRepo.findById(id);
	    if(opt.isPresent()) {
	    	//delete the object
	    	empRepo.deleteById(id);
	    	return "Employee is deleted";
	    }
  		return "Employee is not found for Deletion";
}
	

}
