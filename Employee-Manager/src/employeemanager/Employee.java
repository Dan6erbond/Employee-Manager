/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanager;

/**
 *
 * @author User
 */
public abstract class Employee {
    
    protected String name, job;
    protected HeadEmployee head;
    
    public Employee(String name, String job, HeadEmployee head){
        this.name = name;
        this.job = job;
        this.head = head;
    }
    
    public abstract void doJob();
    
    @Override
    public String toString(){
        return "My name is " + this.name + " and I am doing: " + job;
    }
    
}
