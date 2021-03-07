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
        PrintWriter out;
        PrintWriter cool;
        Finance theFinance = new Finance();
        String[] StringArray;
        int totalOptions;
        int listsOptions;
        int creditorOptions;
        int productOptions;
        int employeeOptions;
        int statsOptions;

        String[] reupProduct;

        boolean reupProductExist;
        String continueOrNaw;

        boolean defContinue;
        double price;
        boolean quitOrNaw = false;
        double price2 = 0.0;
        File myObj = new File("businessProduct.txt");
        Scanner hey = new Scanner(myObj);
        theFinance.addBackTransactions();
        File myOb = new File("investorsBusinessProduct.txt");
        Scanner naw = new Scanner(myOb);
        Employees.getInstance().readAll();
        while(naw.hasNextLine()){
            investorProduct.add(naw.nextLine());
        }
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
            System.out.println();
            System.out.println("1.                                      Info Lists");
            System.out.println("2.                                      Creditors");
            System.out.println("3.                                      Products");
            System.out.println("4.                                      Employee Info");
            System.out.println("5.                                      Statistics");
            System.out.println("6.                                      Quit");
            System.out.println();
            System.out.println("                           ------------------------------");
            try {
                 totalOptions = stdn.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("You have to input a number!");
                stdn.nextLine();
                totalOptions = 7;
            }
            switch (totalOptions) {
                case 1 -> {
                    for(int l = 0; l<7; l++){
                        System.out.println();
                    }
                    System.out.println("Lists Options ");
                    System.out.println("--------------------------------");
                    System.out.println("1.    Investors List");
                    System.out.println("2.    Products List");
                    System.out.println("3.    Creditors List");
                    System.out.println("4.    All Transactions List");
                    System.out.println("5.    Quit");
                    try {
                        listsOptions = stdn.nextInt();
                        stdn.nextLine();
                    }
                    catch(InputMismatchException e){
                        System.out.println("You have to input a number!");
                        stdn.nextLine();
                        listsOptions = 5;
                    }
                    for(int l = 0; l<7; l++){
                        System.out.println();
                    }
                    switch (listsOptions) {
                        case 1:
                            System.out.println("INVESTOR LIST:");
                            if(investorProduct.size()==0){
                                System.out.println("No investors.");
                            }
                            for (String s : investorProduct) {
                                System.out.println(s);
                            }
                            break;
                        case 2:

                            try {

                                System.out.println("Current Product List:");
                                System.out.println("----------------------");
                                System.out.println();
                                System.out.println();
                                System.out.println("Product - Quantity");
                                System.out.println("----------------------");
                                for (int I = 0; productsOnFile.size() - 1 > I; I++) {
                                    String[] product = productsOnFile.get(I).split("   ");
                                    System.out.println(product[0] + "  -  " +product[2] + " units");
                                }
                                System.out.println("----------------------");
                                System.out.println("TOTAL SALES: $" + productsOnFile.get(productsOnFile.size() - 1));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("There are no products in the product list (add some first)");
                            }
                            break;
                        case 3:
                            theFinance.printList();
                            break;
                        case 4:
                            theFinance.tranList();
                            break;
                        case 5:

                            break;
                    }
                }
                case 2 -> {
                    for(int l = 0; l<7; l++){
                        System.out.println();
                    }
                    System.out.println("Creditors Options ");
                    System.out.println("--------------------------------");
                    System.out.println("1.    A creditor has paid you back");
                    System.out.println("2.    A creditor owes you more money");
                    System.out.println("3.    Quit");
                    try {
                        creditorOptions= stdn.nextInt();
                        stdn.nextLine();
                    }
                    catch(InputMismatchException e){
                        System.out.println("You have to input a number!");
                        stdn.nextLine();
                        creditorOptions = 3;
                    }
                    for(int l = 0; l<7; l++){
                        System.out.println();
                    }
                    switch (creditorOptions) {
                        case 1 -> {
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
                        }
                        case 2 -> {
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
                        }
                        case 3-> {

                            break;
                        }
                    }
                }
                case 3 -> {
                    for(int l = 0; l<7; l++){
                        System.out.println();
                    }
                    System.out.println("Product Info Options:");
                    System.out.println("--------------------------------");
                    System.out.println("1.    Restock");
                    System.out.println("2.    Item Sold");
                    System.out.println("3.    Item Quantity Depleted");
                    System.out.println("4.    quit");
                    try {
                        productOptions= stdn.nextInt();
                        stdn.nextLine();
                    }
                    catch(InputMismatchException e){
                        System.out.println("You have to input a number!");
                        stdn.nextLine();
                        productOptions = 4;
                    }
                    for(int l = 0; l<7; l++){
                        System.out.println();
                    }
                    switch (productOptions) {
                        case 1:
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
                                double updatedProfit = Double.parseDouble(productsOnFile.get(productsOnFile.size() - 1)) - prodPrice;
                                productsOnFile.set(productsOnFile.size() - 1, Double.toString(updatedProfit));
                                for (int i = 0; productsOnFile.size() > i; i++) {
                                    reupProduct = productsOnFile.get(i).split("   ");
                                    if (reupProduct[0].toLowerCase().equals(productName)) {
                                        double newNumber;
                                        reupProductExist = true;
                                        newNumber = Double.parseDouble(reupProduct[1]) + productAmount;
                                        reupProduct[1] = Double.toString(newNumber);
                                        if (reupProduct.length == 2) {
                                            productsOnFile.set(i, reupProduct[0] + "   " + reupProduct[1]);
                                        } else {
                                            productsOnFile.set(i, reupProduct[0] + "   " + reupProduct[1] + "   " + reupProduct[2]);
                                        }

                                    }
                                }
                                if (!reupProductExist) {
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
                        case 2:
                            while (defContinue) {
                                boolean productQuaExists = true;
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
                                theFinance.transaction(name, subNumber, price);
                                for (int I = 0; I < productsOnFile.size(); I++) {
                                    StringArray = productsOnFile.get(I).split("   ");
                                    if (name.toUpperCase().equals(StringArray[0].toUpperCase())) {
                                        number = Double.parseDouble(StringArray[1]);
                                        number = number - subNumber;
                                        if (number == 0) {
                                            productsOnFile.remove(I);
                                            break;
                                        }
                                        else if (number < 0){
                                            System.out.println("You do not have enough product to sell that much!");
                                            productQuaExists = false;
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
                                if(productQuaExists) {
                                    if (price2 == 0) {
                                        price2 = price + Double.parseDouble(productsOnFile.get(productsOnFile.size() - 1));
                                    } else {
                                        price2 = price + price2;
                                    }
                                    productsOnFile.set(productsOnFile.size() - 1, Double.toString(price2));
                                    System.out.println("NEW LIST OF PRODUCT:");
                                    for (int I = 0; productsOnFile.size() - 1 > I; I++) {
                                        System.out.println(productsOnFile.get(I));
                                    }
                                    System.out.println("$" + price2);
                                    theFinance.transaction(name, subNumber, price);
                                }
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
                        case 3:
                            System.out.println("Current List:");
                            for (String i : productsOnFile) {
                                System.out.println(i);
                            }
                            System.out.println("What did you use?");
                            String prod = stdn.nextLine();
                            System.out.println("how much did you consume?");
                            double prodAmount = Double.parseDouble(stdn.nextLine());
                            theFinance.depleted(prod, prodAmount);
                            for (int m = 0; productsOnFile.size() > m; m++) {
                                String[] consumedArray = productsOnFile.get(m).split("   ");
                                if (prod.toLowerCase().equals(consumedArray[0].toLowerCase())) {
                                    double currentamount = Double.parseDouble(consumedArray[1]) - prodAmount;
                                    if (consumedArray.length == 2) {
                                        productsOnFile.set(m, consumedArray[0] + "   " + currentamount);
                                    } else if (consumedArray.length == 3) {
                                        productsOnFile.set(m, consumedArray[0] + "   " + currentamount + "   " + consumedArray[2]);
                                    }
                                }
                            }
                            System.out.println("New List:");
                            for (String i : productsOnFile) {
                                System.out.println(i);
                            }
                            break;
                        case 4:

                            break;
                    }

                }
                case 4 -> {
                    for(int l = 0; l<7; l++){
                        System.out.println();
                    }
                    System.out.println("Employee info options:");
                    System.out.println("-----------------------------");
                    System.out.println("1.    Search Employee");
                    System.out.println("2.    Employee Taxes");
                    System.out.println("3.    Add an Employee");
                    System.out.println("4.    Add an hours worked for an Employee");
                    System.out.println("5.    Quit");
                    try {
                        employeeOptions = stdn.nextInt();
                        stdn.nextLine();
                    }
                    catch(InputMismatchException e){
                        System.out.println("You have to input a number!");
                        stdn.nextLine();
                        employeeOptions = 4;
                    }
                    for(int l = 0; l<7; l++){
                        System.out.println();
                    }
                    switch (employeeOptions) {


                        case 1:
                            System.out.println("What is the name of the employee?");
                            String name = stdn.nextLine();
                            if(Employees.getInstance().getEmployee(name) == null) {
                                System.out.println("This employee does not exist in the database!");
                            }
                            else{
                               System.out.println(Employees.getInstance().getEmployee(name));
                            }
                            break;
                        case 2:
                            System.out.println("What is the name of the employee?");
                            name = stdn.nextLine();
                            taxes.lookup(name);

                            break;
                        case 3:
                            System.out.println("What is the name of the employee?");
                            name = stdn.nextLine();
                            System.out.println("What is the ID of the employee?");
                            int id = stdn.nextInt();
                            System.out.println("How many hours did the employee work?");
                            double hourWorked = stdn.nextDouble();
                            System.out.println("How much does the employee make per hour?");
                            double hourlyPay = stdn.nextDouble();
                            stdn.nextLine();
                            System.out.println("Is the employee active or non-active?");
                            String status = stdn.nextLine();
                            System.out.println("What position does the employee hold?");
                            String position = stdn.nextLine();

                            Employee employee = new Employee(id, name, hourWorked, hourlyPay, status, position);
                            Employees.getInstance().add(name, employee);
                            Employees.getInstance().writeAll();
                            break;
                        case 4:
                            System.out.println("What is the name of the employee?");
                            name = stdn.nextLine();
                            System.out.println("How many more hours did they work?");
                            int additionalHours = stdn.nextInt();
                            Employees.getInstance().getEmployee(name).addHoursWorked(additionalHours);
                            break;
                        case 5:
                            break;
                    }
                }
                case 5 -> {
                    for(int l = 0; l<7; l++){
                        System.out.println();
                    }
                    System.out.println("Statistics Options:");
                    System.out.println("-----------------------------");
                    System.out.println("1.    Daily Stats");
                    System.out.println("2.    Weekly Stats");
                    System.out.println("3.    Monthly Stats");
                    System.out.println("4.    Yearly Stats");
                    System.out.println("5.    Quit");
                    try {
                        statsOptions = stdn.nextInt();
                        stdn.nextLine();
                    }
                    catch(InputMismatchException e){
                        System.out.println("You have to input a number!");
                        stdn.nextLine();
                        statsOptions = 5;
                    }
                    for(int l = 0; l<7; l++){
                        System.out.println();
                    }
                    switch (statsOptions) {
                        case 1:


                            break;
                        case 2:


                            break;
                        case 3:


                            break;
                        case 4:


                            break;
                        case 5:

                            break;
                    }
                }
                case 6 -> {
                    quitOrNaw = true;
                }
                case 7 -> System.out.println("try again!");

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
