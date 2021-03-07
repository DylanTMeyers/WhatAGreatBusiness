package com.company;

public class taxes {
    private String name;


    public void lookup(String name){
        this.name = Employees.getInstance().getemployee((name));
        if(!this.name.equals("Nothing found")){
            System.out.println("We found something");
            print();
        }
    }

    public void print(){

    }
}
