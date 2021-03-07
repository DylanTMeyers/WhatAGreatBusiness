package com.company;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.*;
import java.io.*;

public class Employee{

	private int ID;
	private String name;
	private double hoursWorked;
	private double hourlyPay;
	private String status;
	private String position;
	private double monthlyIncome; // not used yet

	public Employee(int ID, String name, double hoursWorked, double hourlyPay, String status, String position){
		this.ID = ID;
		this.name = name;
		this.hoursWorked = hoursWorked; 
		this.hourlyPay = hourlyPay;
		this.status = status; 
		this.position = position;
	}
	public int getID(){
		return ID;
	}
	public double getPay(){
		return hoursWorked * hourlyPay;
	}
	public double getHoursWorked(){
		return hoursWorked;
	}
	public void setHoursWorked(int hours){
		this.hoursWorked = hours;
	}
	public double getHourlyPay(){
		return hourlyPay;
	}
	public void setHourlyPay(int hours){
		this.hoursWorked = hours;
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getPosition(){
		return position;
	}
	public void setPosition(String position){
		this.position = position;
	}
	public String toString(){
		return ID + " " + name + " " + hoursWorked + " " + hourlyPay + " " + status + " " + position;
	}
	public void printToFile(){
		// put data in a text file
		try {
		      FileWriter myWriter = new FileWriter("file.txt");	
		      myWriter.write("hi");
		}
		catch(IOException e){
			System.out.println("Error: file could not be written to.");
			System.exit(-1);
		}
	}
}
