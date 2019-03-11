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
public class Janitor extends Employee {

    public Janitor(String name, String job) {
        super(name, job);
    }
    
    @Override
    public void doJob() {
        System.out.println(this.toString());
    }
    
}
