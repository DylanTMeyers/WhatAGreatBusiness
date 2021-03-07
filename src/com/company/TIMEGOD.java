package com.company;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TIMEGOD {

    private String payday;//the day you pay your employees
    private String payed;//option to say if you paid them or not

    private TIMEGOD[] year;//an array to store data when it's not leap year
    private TIMEGOD[] leapYear;//an array to store data when it's a leap year
    private boolean normalYear;//boolean to say if leap year or not

    //today's date
    private int date[];

    private double sales;//today's sales
    private double profit;//today's profit
    private double cost;//today's cost

    //these are the days of the month to keep track of
    //                   1  2  3  4  5  6  7  8  9 10 11 12
    int calender[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    //                       1  2  3  4  5  6  7  8  9 10 11 12
    int calenderLeap[] = {0,31,29,31,30,31,30,31,31,30,31,30,31};

    TIMEGOD() {
        this.sales = 0;
        this.profit = 0;
        this.cost = 0;

        this.year = new TIMEGOD[365];
        this.leapYear = new TIMEGOD[366];

        this.payday = "thursday";

    }//end of timegod constructor

    //method to get current date
    public int today() {
        int day = 0;

        Date today = new Date();//gets the date
        //formats it to mm dd yyyy
        SimpleDateFormat today2 = new SimpleDateFormat("MM/dd/yyyy");
        String b = today2.toString();//turns into string
        String[] thing = b.split("[/]");//splits the string
        for(int i = 0; i < thing.length; i++){
            int uio = Integer.parseInt(thing[i]);//makes it into an int
            this.date[i] = uio;//puts the int into the date array
        }//end of for

        if(date[2] % 4 == 0) {//if the year is divisible by 4 it's a leap
            this.normalYear = false;//mark it as leap
        }//end of if
        else{//otherwise it's normal
            this.normalYear = true;//mark it as normal
        }//end of else

        day+= date[1];//adds the days to the day

        if(this.normalYear){//if this is a normal year
            //adds in the days till the month it's reached
            //minus the one it's on so it doesnt add extra days
            for(int i = 0; i < date[0]-1; i++){
                day+= calender[i];
            }//end of for
        }//end of if
        else{//if it's not a normal year
            //adds in the days till the month it's reached
            //minus the one it's on so it doesnt add extra days
            for(int i = 0; i < date[0]-1; i++){
                day+= calenderLeap[i];
            }//end of for
        }//end of else

        return day;
    }//end of today method

    //method to put in today's sales, profit, cost
    public void insert(double sales , double profit, double cost){

    }//end of insert

    //method to show year's stats

    //method to show months stats

    //method to show week's stats

    //method to show today's stats



}//end of TIMEGOD
