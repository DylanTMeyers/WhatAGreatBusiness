package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Finance {
    String creditor;
    boolean credyeah;
    ArrayList<String> transaction = new ArrayList<>(10);
    ArrayList<String> creditors = new ArrayList<>(10);
    File myOb = new File("creditor.txt");
    File myTran = new File("transaction.txt");
    Scanner hey = new Scanner(myTran);
    Scanner naw = new Scanner(myOb);
    String[] credStringArray;
    double credNumber;
    Finance() throws IOException {
        while(naw.hasNextLine()){
            creditors.add(naw.nextLine());
        }
    }
    public String getCreditors(){
        return this.creditor;
    }
    public void setCreditors(String creditor){
        this.creditor = creditor;
    }
    public void addCreditors(String name,int add) {
        credyeah = false;
        transaction.add(name + " gave $" + add + " in credit");
        for (int I = 0; I < creditors.size(); I++) {
            credStringArray = creditors.get(I).split(" ");
            if (name.toUpperCase().equals(credStringArray[0].toUpperCase())) {
                credyeah = true;
                credNumber = Double.parseDouble(credStringArray[1]);
                credNumber = credNumber + add;
                credNumber = Math.round(credNumber * 10.0) / 10.0;
                credStringArray[1] = Double.toString(credNumber);
                creditors.set(I, credStringArray[0] + " " + credStringArray[1]);
                break;
            }
        }
        if(!credyeah) {
            creditors.add(name + " " + add);
        }
    }
    public void subCreditors(String name,int sub){
        transaction.add(name + " paid back $" + sub );
        credyeah = false;
        for (int I = 0; I < creditors.size(); I++) {
            credStringArray = creditors.get(I).split(" ");
            if (name.toUpperCase().equals(credStringArray[0].toUpperCase())) {
                credyeah = true;
                credNumber = Double.parseDouble(credStringArray[1]);
                credNumber = credNumber - sub;
                credNumber = Math.round(credNumber * 10.0) / 10.0;
                if(credNumber<=0){
                    creditors.remove(I);
                    break;
                }
                credStringArray[1] = Double.toString(credNumber);
                creditors.set(I, credStringArray[0] + " " + credStringArray[1]);
                break;
            }
        }
        if(!credyeah) {
            System.out.println("Name does not exist in documentation");
        }
    }
    public void fileSet() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("creditor.txt"));
        for(String credit: creditors) {
            out.println(credit);
        }
        out.close();
    }
    public void printList(){
        for(String credit: creditors) {
            System.out.println(credit);
        }
    }
    public void tranList(){
        for(String tran: transaction){
            System.out.println(tran);
        }
    }
    public void addBackTransactions(){
        while(hey.hasNextLine()){
            transaction.add(hey.nextLine());
        }
    }
    public void printTransactions() throws IOException {
        PrintWriter nah = new PrintWriter(new FileWriter("transaction.txt"));
        for (String i : transaction) {
            nah.println(i);
        }
        nah.close();
    }
    public void transaction(String item, double prodQua,double cost){
        transaction.add("Sold "+prodQua + " of " + item+ " for $"+ cost);

    }public void tranReup(String item, double prodqua, double cost){
        transaction.add("Bought " + prodqua + " of " + item + " for $" + cost);
    }public void invPaidOff(String name, int amount){

    }public void Consumed(String item, double amount){
        transaction.add("Somebody consumed " + amount + " of " + item);

    }


}
