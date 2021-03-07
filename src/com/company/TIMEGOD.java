package com.company;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TIMEGOD {


    /**
     * these variables down below needs to be kept track of
     * inside of a text file when it's saved
     * there is a method for it
     */
    private report[] year;//an array to store data when it's not leap year
    private report[] leapYear;//an array to store data when it's a leap year
    private boolean normalYear;//boolean to say if leap year or not
    private int theDay; // the number of the assumed today day

    TIMEGOD() {

        this.year = new report[365];
        this.leapYear = new report[366];
        this.theDay = 0;

    }//end of timegod constructor

    /**
     * this grabs the current date by the form
     * mm/dd/yyyy
     * @return
     */
    public static String theDate(){
        Date bill = new Date();
        SimpleDateFormat day = new SimpleDateFormat("MM/dd/yyyy");
        return day.format(bill);
    }//end of date

    /**
     * this entire method is to get today's date to keep track of things
     * it grabs all the info on today and returns a number that's the
     * current day in the year from the array to use for the day
     * I find an easier way to do this later, by my god isn't this code
     * BEUTIFUL    update: i deleted it....
     * @return
     */
    //method to get current date
    public int today() {

        Date today = new Date();//gets the date
        //formats it to mm dd yyyy
        SimpleDateFormat today2 = new SimpleDateFormat("D");
        String b = today2.format(today);//turns into string

        return Integer.parseInt(b);//returns as an intiger
    }//end of today method


    /**
     * this method returns wether it's a new day or not
     * it does this by keeping track of the assumed today
     * and a recount of today's date. If it's the same, it
     * is not a new day, if it's different it's a new day
     * this method is being used in the method below, don't worry
     * about this
     * @return
     */
    //this method will be used to see if it's a new day
    public boolean newDay(){

        int bob = today();//grabs the number of today's date
        if(bob==theDay){//it today matches with theDay it's the same day
            return false;
        }
        else{//if it doesn't match then it's a new day
            theDay = bob;//makes this the new day
            return true;
        }

    }//end of newDay

    /**
     * checks to see if this an empty day or not
     * @param bob
     * @return
     */
    //method to see if there is no report in that day
    //don't worry about this method
    private boolean empty(int bob){
        if(this.year[bob] == null){//checks this day if it's null
            return true;//it is empty
        }//end of if
        else{//if it's not empty there is a report
            return false;
        }//end of else
    }//end of empty

    /**
     * call this method first to make a report for the day
     * will be used to add on every sale to keep track
     * if it's not a newday, no new report will be made
     * and then the record will be kept track of
     * this may happen in case someone re opens this program
     */
    //method to put in today's sales, profit, cost
    public void write(double profit, double sales){
        int bob = today();//grabs the today's date
        if(newDay()) {//if it's a new day
            report tom = new report();//make a report for today

            this.year[bob] = tom;//put it in the record

            theDay = bob;//make today the new day
            this.year[bob].sell(profit,sales);
        }//end of if
        else{//it it's the same day, don't do anything just
            this.year[bob].sell(profit,sales);//keep track of sale/profit on day
        }//end of else
    }//end of write

    /**
     * this method will be used when you buy something
     * it kepps track of the total cost of how much you spend
     * that day to buy a product, use this when you purchase
     * a new product like during a reup
     */
    public void write(double cost){
        int bob = today();//grabs today num in year
        if(newDay()) {//sees if it's a new day if so
            report tom = new report();//makes a report for the day
            this.year[bob] = tom;//places it in the record
            theDay = bob;//makes this the new day

            this.year[bob].bought(cost);//increases cost in this day
        }//end of if
        else{//if it's not
            this.year[bob].bought(cost);//increases cost in this day
        }//end of else
    }//end of buys

    /**
     * this method is to show today's report
     * it shows sales profits and cost of that day
     */
    //method to show today's stats
    public void todayReport(){

        int bob = today();//gets the date

        //gets all the cost sales and profit for the day
        double cost = this.year[bob].getCost();
        double sales = this.year[bob].getSales();
        double profit = this.year[bob].getProfit();

        System.out.println(" ");
        System.out.println(" Sales UwU: " + sales);
        System.out.println(" Profits UwU: " + profit);
        System.out.println(" Cost UwU: " +cost);
        System.out.println(" ");

    }//end of todayReport

    /**
     * this is a method that grabs the day report of whatever day
     * it is being told to do, if there is not report it says that
     * nothing happend that day
     * @param bob
     */
    //method to show a day's report
    private void thatDayReport(int bob){
        if(!empty(bob)) {
            double cost = this.year[bob].getCost();
            double sales = this.year[bob].getSales();
            double profit = this.year[bob].getProfit();
            String date = this.year[bob].getDate();

            System.out.println(" ");
            System.out.println(" Date: " +  date);
            System.out.println(" Sales UwU: " + sales);
            System.out.println(" Profits UwU: " + profit);
            System.out.println(" Cost UwU: " + cost);
            System.out.println(" ");
        }
        else{
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }

    }//end of thatDayReport

    /**
     * this method gets the year report, to do this, it simply
     * prints out the entire year
     */
    //method to show year's stats

    /**
     * this gets the month reports by grabbing the day of the month
     * and then looping up to it and printing everything
     */
    //method to show months stats
    public void monthReport(){
        Date date = new Date();//grabs the date
        SimpleDateFormat day = new SimpleDateFormat("d");
        String bob = day.format(date);//gets the day in the month
        int tom = Integer.parseInt(bob);//puts it into a number

        int today = today();//todays number in year

        for(int i = 0; i < tom; i++){
            thatDayReport((today-tom)+i);
        }//end of for

    }//end of monthReport

    /**
     * this method prints out the current week's records
     * this is done by seeing what day it is and gathers the data
     * of it, if there is no data, it shows happy faces
     */
    //method to show week's stats
    public void weekReport(){
        Date date = new Date();//grabs the date
        //formats it to see what day of the week it is
        SimpleDateFormat day = new SimpleDateFormat("E");
        String bob = day.format(date);//gets the day

        System.out.println(" ");
        System.out.println("  here is the current week's report uwu");
        System.out.println(" ");

        int tom = today();//the day of the current year

        //to see what day it is
        switch(bob){
            case "Mon":
                thatDayReport(tom-1);
                thatDayReport(tom);
                break;
            case "Tue":
                thatDayReport(tom-2);
                thatDayReport(tom-1);
                thatDayReport(tom);
                break;
            case "Wed":
                thatDayReport(tom-3);
                thatDayReport(tom-2);
                thatDayReport(tom-1);
                thatDayReport(tom);
                break;
            case "Thu":
                thatDayReport(tom-4);
                thatDayReport(tom-3);
                thatDayReport(tom-2);
                thatDayReport(tom-1);
                thatDayReport(tom);
                break;
            case "Fri":
                thatDayReport(tom-5);
                thatDayReport(tom-4);
                thatDayReport(tom-3);
                thatDayReport(tom-2);
                thatDayReport(tom-1);
                thatDayReport(tom);
                break;
            case "Sat":
                thatDayReport(tom-6);
                thatDayReport(tom-5);
                thatDayReport(tom-4);
                thatDayReport(tom-4);
                thatDayReport(tom-3);
                thatDayReport(tom-2);
                thatDayReport(tom-1);
                thatDayReport(tom);
                break;
            case "Sun":
                thatDayReport(tom);
                break;
        }//end of switch


    }//end of weekReport



}//end of TIMEGOD
