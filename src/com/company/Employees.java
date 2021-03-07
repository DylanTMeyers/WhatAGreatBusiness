package com.company;

import java.util.ArrayList;
import java.util.Hashtable;

public class Employees{
    int count;
    private static Employees employees;
    Hashtable<String, Employee> track = new Hashtable<>();

    public static synchronized Employees getInstance(){
        if(employees == null){
            employees = new Employees();
        }
        return employees;
    }
    public void add(String a, Employee b){
        track.put(a, b);
        count++;
    }


    public int total(){
        return count;
    }

    public void delete(int a){
        track.remove(a);
        count--;
    }

    public Employee getemployee(String a){
        return track.get(a);
    }//end of method
}
