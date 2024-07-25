package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService  empService;
	
	@GetMapping("/")
	public  String  showHomePage() {
		//return  LVN
		return  "welcome";
	}
	
	@GetMapping("/report")   // G---- Get
	public    String   generateReport(Map<String,Object> map) {
		System.out.println("EmployeeOperationsController.generateReport()");
		//use  service
		Iterable<Employee>  it=empService.showAllEmployees();
		//keep the result in  model attribute (Shared  memory)
		map.put("empList", it);
		//return LVN
		return "show_report";
	}
	
	@GetMapping("/register")  //register  employee --- form launching
	public    String    showEmployeeRegisterFormPage(@ModelAttribute("emp") Employee  emp) {
		//retiurn LVN (register form page)
		return "register_employee_form";
		
	}
	
	/*@PostMapping("/register")    // P --POST
	public  String     saveEmployee(@ModelAttribute("emp") Employee emp,
			                                                   RedirectAttributes  attrs) {
		System.out.println("EmployeeOperationsController.saveEmployee()");
		//use  service
		String msg=empService.registerEmployee(emp);
			// keep the result model attribute (shared Memory)
	   attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";  // R -- Redirect 
		
	}*/
	
	@PostMapping("/register")    // P --POST
	public  String     saveEmployee(@ModelAttribute("emp") Employee emp,
			                                                  HttpSession  ses) {
		System.out.println("EmployeeOperationsController.saveEmployee()");
		//use  service
		String msg=empService.registerEmployee(emp);
			// keep the result model attribute (shared Memory)
	   ses.setAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";  // R -- Redirect 
		
	}
	
	
	@GetMapping("/edit")  // launching edit form page
	public    String  showEditFormPage(@RequestParam Integer no,
			                                                           @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOperationsController.showEditFormPage()");
		//use service
		 Employee  emp1=empService.findEmployeeByNo(no);
		 BeanUtils.copyProperties(emp1, emp);  //copies  one obj data to another obj if both objs are having same propety names
		//return LVN
		return "edit_employee_form";
	}
	
	@PostMapping("/edit")  // edit  operation for submission page
	public    String    updateEmployee(@ModelAttribute("emp") Employee emp,
			                                                        RedirectAttributes  attrs) {
		//use service
		 String msg=empService.updateEmployee(emp);
		//keep the  result  in shared memory
		   attrs.addFlashAttribute("resultMsg", msg);
		 
		 //return LVN
		 return  "redirect:report";
		 
	}
	
	@GetMapping("/delete")
	public  String  removeEmployeeById(@RequestParam Integer no,
			                                                              RedirectAttributes attrs) {
		//use service
		String msg=empService.removeEmployeeById(no);
		//keep the result in model attribute
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}

}
