package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Product {
    String productName;
    double productAmount;
    String productInvestor;
    boolean hasAInvestor;
    String product;
    double investorAmount;
    char name;
    PrintWriter out;
    Product(String productName, double productAmount){
        this.productName = productName;
        this.productAmount = productAmount;
    }
    Product(String productName, double productAmount, String productInvestor) throws IOException {
        this.productName = productName;
        this.productAmount = productAmount;
        this.productInvestor = productInvestor;
        hasAInvestor = true;
        PrintWriter out;
        out = new PrintWriter(new FileWriter("investorsBusinessProduct.txt"));
        this.out = out;
    }

    public String toString(){
        if(hasAInvestor){
            return productName + "   " + productAmount + "   " + productInvestor;
        }
        return productName + "   " + productAmount;
    }
    public void setInvestorAmount(char name, double investorAmount, String product) {
        this.name = name;
        this.investorAmount= investorAmount;
        this.product = product;
    }
    public String getInvestorAmount() {

        return name + " "+ investorAmount+ " " + product.toUpperCase();
    }
    public static double toAnOunce(double number) {
        double lastOunce = 0;
        for(int i = 0; i<number; i = i +28){
            lastOunce = i;


        }
        return lastOunce;
    }
    public  void close(){
        out.close();
    }
}
