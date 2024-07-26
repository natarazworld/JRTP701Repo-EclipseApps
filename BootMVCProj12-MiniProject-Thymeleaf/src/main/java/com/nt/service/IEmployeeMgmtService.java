package com.nt.service;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
    public   Iterable<Employee>  showAllEmployees();
    public   String    registerEmployee(Employee emp);
    public    Employee   findEmployeeByNo(int no);
    public   String    updateEmployee(Employee emp);
    public  String   removeEmployeeById(int id);
}
