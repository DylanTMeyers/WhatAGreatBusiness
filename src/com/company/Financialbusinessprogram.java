package com.company;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Financialbusinessprogram {
    public static void main(String[] args) throws IOException {
        Scanner stdn = new Scanner(System.in);
        ArrayList<String> productsOnFile = new ArrayList<>(10);
        ArrayList<String> investorProduct = new ArrayList<>(10);
        Hashtable<String, Double> Locations = new Hashtable<>();
        PrintWriter out;
        PrintWriter cool;
        Finance theFinance = new Finance();
        String[] StringArray;
        String[] invStringArray;
        String[] reupProduct;
        String[] justOne;
        boolean reupProductExist;
        String continueOrNaw;

        boolean defContinue;
        double price;
        boolean quitOrNaw = false;
        double price2 = 0.0;
        double subNumber2;
        String option;
        File myObj = new File("businessProduct.txt");
        Scanner hey = new Scanner(myObj);
        theFinance.addBackTransactions();
        while(hey.hasNextLine()){
            if(hey.hasNext("CANDY")){
                break;
            }
            productsOnFile.add(hey.nextLine());
        }
        while(!quitOrNaw) {
            defContinue = true;
            System.out.println("                             ------------------------------");
            System.out.println();
            System.out.println("                                    CHOOSE AN OPTION:");
            System.out.println("                                     Investor List");
            System.out.println("                                     Product List");
            System.out.println("                                     Creditor List");
            System.out.println("                                    Transaction list");
            System.out.println("                                      Creditor Add");
            System.out.println("                                      Creditor Sub");
            System.out.println("                                        Restock");
            System.out.println("                                         Sold");
            System.out.println("                                       Consumed");
            System.out.println("                                     Search Employee");
            System.out.println("                                        Taxes");
            System.out.println("                                     Add Employee");
            System.out.println("                                   Show Current Week");
            System.out.println("                                   Show Current Day");
            System.out.println("                                   Show Current Month");
            System.out.println("                                   Show Current Year");
            System.out.println("                                        Quit");
            System.out.println();
            System.out.println("                             ------------------------------");
            option = stdn.nextLine();
            switch (option.toLowerCase()) {
                case "investor list":
                    System.out.println("INVESTOR LIST:");
                    for (String s : investorProduct) {
                        System.out.println(s);
                    }
                    break;
                case "product list":
                    try {
                        System.out.println("Current Product List:");
                        System.out.println("----------------------");
                        System.out.println("Product  Quantity");
                        System.out.println("----------------------");
                        for (int I = 0; productsOnFile.size() - 1 > I; I++) {
                            System.out.println(productsOnFile.get(I));
                        }
                        System.out.println("----------------------");
                        System.out.println("TOTAL SALES: $" + productsOnFile.get(productsOnFile.size() - 1));
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("There are no products in the product list (add some first)");
                    }
                    break;
                case "creditor list":
                    theFinance.printList();
                    break;
                case"transaction list":
                    theFinance.tranList();

                    break;
                case "cred sub":
                    System.out.println("THE CURRENT CRED LIST:");
                    theFinance.printList();
                    System.out.println("What is the name of the creditor?");
                    String credName = stdn.nextLine();
                    System.out.println("What is the number you would like to subtract?");
                    int credSub = Integer.parseInt(stdn.nextLine());
                    theFinance.subCreditors(credName, credSub);
                    theFinance.fileSet();
                    System.out.println("THE NEW CRED LIST:");
                    theFinance.printList();
                    break;
                case "cred add":
                    System.out.println("THE CURRENT CRED LIST:");
                    theFinance.printList();
                    System.out.println("What is the name of the creditor?");
                    String credName2 = stdn.nextLine();
                    System.out.println("What is the number you would like to add?");
                    int credInt = Integer.parseInt(stdn.nextLine());
                    theFinance.addCreditors(credName2, credInt);
                    theFinance.fileSet();
                    System.out.println("THE NEW CRED LIST:");
                    theFinance.printList();
                    break;
                case "restock":
                    while (defContinue) {
                        reupProductExist = false;
                        for (int I = 0; productsOnFile.size() - 1 > I; I++) {
                            System.out.println(productsOnFile.get(I));
                        }

                            System.out.println("What is the product name?");
                            String productName = stdn.nextLine();
                            System.out.println("What is the amount of product?");
                            double productAmount = Double.parseDouble(stdn.nextLine());
                            System.out.println("How much did you buy it for?");
                            double prodPrice = Double.parseDouble(stdn.nextLine());
                            theFinance.tranReup(productName, productAmount, prodPrice);
                            for (int i = 0; productsOnFile.size()>i;i++) {
                                reupProduct = productsOnFile.get(i).split("   ");
                                if (reupProduct[0].toLowerCase().equals(productName)) {
                                    double newNumber;
                                    reupProductExist = true;
                                    newNumber = Double.parseDouble(reupProduct[1]) + productAmount;
                                    reupProduct[1] = Double.toString(newNumber);
                                    if(reupProduct.length ==2) {
                                        productsOnFile.set(i, reupProduct[0] + "   " + reupProduct[1]);
                                    }
                                    else{
                                        productsOnFile.set(i, reupProduct[0] + "   " + reupProduct[1] + "   " + reupProduct[2]);
                                    }

                                }
                            }
                            if(!reupProductExist) {
                                Product product = new Product(productName.toUpperCase(), productAmount);
                                out = new PrintWriter(new FileWriter("businessProduct.txt"));
                                for (int i = 0; i < productsOnFile.size() - 1; i++) {
                                    out.println(productsOnFile.get(i));
                                }
                                out.println(product);
                                if (productsOnFile.size() - 2 >= 0) {
                                    out.println(productsOnFile.get(productsOnFile.size() - 1));
                                    productsOnFile.add(productsOnFile.size() - 2, product.toString());
                                }
                                out.close();
                            }

                        System.out.println("Would you like to continue (if you dont want to continue type no)");
                        continueOrNaw = stdn.nextLine();
                        if (continueOrNaw.toLowerCase().equals("no")) {
                            defContinue = false;
                        }
                    }
                    break;
                case "sold":
                    while (defContinue) {
                        System.out.println("LIST OF PRODUCTS:");
                        for (int I = 0; productsOnFile.size() - 1 > I; I++) {
                            System.out.println(productsOnFile.get(I));
                        }
                        if (price2 > 0) {
                            System.out.println("$" + price2);
                        } else {
                            System.out.println("$" + productsOnFile.get(productsOnFile.size() - 1));
                        }
                        double number;
                        System.out.println("What is the name of the product you sold?");
                        String name = stdn.nextLine();
                        System.out.println("How much product did you sell?");
                        double subNumber = Double.parseDouble(stdn.nextLine());
                        System.out.println("how much did this product sell for?");
                        price = Double.parseDouble(stdn.nextLine());
                        theFinance.transaction(name,subNumber,price);
                        for (int I = 0; I < productsOnFile.size(); I++) {
                            StringArray = productsOnFile.get(I).split("   ");
                            if (name.toUpperCase().equals(StringArray[0].toUpperCase())) {
                                number = Double.parseDouble(StringArray[1]);
                                number = number - subNumber;
                                if(number<= 0){
                                    productsOnFile.remove(I);
                                    break;
                                }
                                number = Math.round(number * 10.0) / 10.0;
                                StringArray[1] = Double.toString(number);
                                if (StringArray.length == 2) {
                                    productsOnFile.set(I, StringArray[0] + "   " + StringArray[1]);
                                } else if (StringArray.length == 3) {
                                    productsOnFile.set(I, StringArray[0] + "   " + StringArray[1] + "   " + StringArray[2].toUpperCase());
                                }
                            }
                        }
                        if (price2 == 0) {
                            price2 = price + Double.parseDouble(productsOnFile.get(productsOnFile.size() - 1));
                        } else {
                            price2 = price + price2;
                        }
                        productsOnFile.set(productsOnFile.size()-1, Double.toString(price2));
                        System.out.println("NEW LIST OF PRODUCT:");
                        for (int I = 0; productsOnFile.size() - 1 > I; I++) {
                            System.out.println(productsOnFile.get(I));
                        }
                        System.out.println("$" + price2);
                        System.out.println("Would you like to continue? (if you dont want to continue type no)");
                        continueOrNaw = stdn.nextLine();
                        if (continueOrNaw.toLowerCase().equals("no")) {
                            out = new PrintWriter(new FileWriter("businessProduct.txt"));
                            for (int I = 0; productsOnFile.size() - 1 > I; I++) {
                                out.println(productsOnFile.get(I));
                            }
                            out.println(price2);
                            out.close();
                            defContinue = false;
                        }
                    }
                    break;
                case "quit":
                    quitOrNaw = true;
                    break;
                case "consumed":
                    System.out.println("Current List:");
                    for(String i: productsOnFile){
                        System.out.println(i);
                    }
                    System.out.println("What did you use?");
                    String prod = stdn.nextLine();
                    System.out.println("how much did you consume?");
                    double prodAmount = Double.parseDouble(stdn.nextLine());
                    theFinance.Consumed(prod,prodAmount);
                    for(int m = 0; productsOnFile.size()>m; m++){
                        String[] consumedArray = productsOnFile.get(m).split("   ");
                        if(prod.toLowerCase().equals(consumedArray[0].toLowerCase())) {
                            double currentamount = Double.parseDouble(consumedArray[1]) - prodAmount;
                            if (consumedArray.length == 2) {
                                productsOnFile.set(m, consumedArray[0] + "   " + currentamount);
                            } else if (consumedArray.length == 3) {
                                productsOnFile.set(m, consumedArray[0] + "   " + currentamount + "   " + consumedArray[2]);
                            }
                        }
                    }
                    System.out.println("New List:");
                    for(String i: productsOnFile){
                        System.out.println(i);
                    }
                    break;
                case "Search Employee":



                    break;
                case "Taxes":



                    break;
                case "Add Employee":



                    break;
                case "Current Day":



                    break;
                case "Current":



                    break;
            }
            }
        cool = new PrintWriter(new FileWriter("investorsBusinessProduct.txt"));
        for (String s : investorProduct) {
            cool.println(s);
        }
        theFinance.printTransactions();

        cool.close();
    }
}
