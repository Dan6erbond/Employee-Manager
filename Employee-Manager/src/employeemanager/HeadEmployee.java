/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanager;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public abstract class HeadEmployee extends Employee {
    
    private ArrayList<Employee> employees = new ArrayList<>();
    
    public HeadEmployee(String name, String job){
        super(name, job);
    }
    
    @Override
    public void doJob(){
        System.out.println(this.toString());
        for (Employee employee : employees){
            employee.doJob();
        }
    }
    
    public void add(Employee employee){
        this.employees.add(employee);
    }
    
    public void add(ArrayList<Employee> employees){
        this.employees.addAll(employees);
    }
    
    public void remove(Employee employee){
        this.employees.remove(employee);
    }
    
}
