package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class taxes {


    public static void lookup(String name){
        Employees.getInstance().getemployee((name));
        if(name != null){
            System.out.println("We found something");
            print(name);
        }
    }

    public static void print(String name){
        try{
            FileWriter myWriter = new FileWriter("Taxes");
            double hourlyPay = Employees.getInstance().track.get(name).getHourlyPay();
            int id = Employees.getInstance().track.get(name).getID();
            double totalpayy = Employees.getInstance().track.get(name).getTotalincome();
            double medicaretax = 2.9 * totalpayy;
            double statetax = 4.3 * totalpayy;
            double federaltax = 0;
            if(totalpayy > 0 && totalpayy < 9875){
                    federaltax = totalpayy * 10;
            }else if(totalpayy > 9875 && totalpayy < 40125){
                    federaltax = totalpayy * 12;
            }else if(totalpayy > 40125 && totalpayy < 85525){
                    federaltax = totalpayy * 22;
            }else if(totalpayy > 85525 && totalpayy < 163300){
                    federaltax = totalpayy * 24;
            }else if(totalpayy > 163300 && totalpayy < 207350){
                    federaltax = totalpayy * 32;
            }else if(totalpayy > 207350 && totalpayy < 518400){
                    federaltax = totalpayy * 35;
            }else if(totalpayy > 518400){
                    federaltax = totalpayy * 37;
            }

            myWriter.write("-----------------Taxes-----------------");
            myWriter.write("Employee ID: " + id + "      Employee Name: " + name);
            myWriter.write("Hourly pay: " + hourlyPay);
            myWriter.write("Yearly pay " + totalpayy);
            myWriter.write("Medicare Tax " + medicaretax);
            myWriter.write("State Tax " + statetax);
            myWriter.write("Federal Tax: " + federaltax);


        }catch(IOException e){
            System.out.println("ERROR!");
        }
    }
}
