/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanager;

import java.util.Observable;

/**
 *
 * @author User
 */
public class Company extends Observable {     
    
    private final CEO ceo = new CEO("Bill", "lead");
    private Employee selected;
    
    public Company (){
        DepartmentHead dp = new DepartmentHead("Max", "programming", ceo);
        Janitor j1 = new Janitor("Hans", "cleaning", dp);
        Janitor j2 = new Janitor("Nick", "cleaning", dp);
        dp.add(j1);
        dp.add(j2);
        ceo.add(dp);
    }
    
    public CEO getCEO(){
        return ceo;
    }
    
    public void setSelected(Employee selected){
        this.selected = selected;
        setChanged();
        notifyObservers();
    }
    
    public void goBack(){
        if (getSelected().head != null)
            setSelected(getSelected().head);
    }
    
    public Employee getSelected(){
        return selected;
    }
    
    public String getSelectedName(){
        return selected.name;
    }
    
    public String getSelectedJob(){
        return selected.job;
    }
    
}
