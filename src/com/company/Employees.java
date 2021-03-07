package com.company;

import java.util.ArrayList;
import java.util.Hashtable;

public class Employees{
    int count;
    private static Employees employees;
    Hashtable<Integer, String> track = new Hashtable<>();
    ArrayList<String> bob = new ArrayList<>();

    public static synchronized Employees getInstance(){
        if(employees == null){
            employees = new Employees();
        }
        return employees;
    }
    public void add(int a, String b){
        track.put(a, b);
        bob.add(b + " " + a);
        count++;
    }


    public int total(){
        return count;
    }

    public void delete(int a){
        track.remove(a);
        count--;
    }

    public String getemployee(String a){
        for (String s : bob) {
            String suad = s.substring(s.length() - 1);
            int b = Integer.parseInt(suad);
            track.get(b);
            if (track.get(b).equals(a)) {
                return track.get(b);
            }//end of if
        }//end of for
        return "Nothing found";
    }//end of method
}
