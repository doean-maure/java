package com.bank.models;

import java.util.List;

public class Admin extends Users{

    public BankAccount account;

    public Admin(int id, String mobileNum, int pin, String name, String address, double balance, String role) {
        super(id, mobileNum, pin, name, address, balance, "Admin");
    }
    
    // Viewing of All Accounts
    public void viewAllBalances(List<Users> userList) { 
        System.out.println("------------------------------------------------");
        System.out.println("\t\tVIEW ALL BALANCES");
        System.out.println("------------------------------------------------");
        System.out.println("FULL NAME\tMOBILE NUMBERS\tBALANCE");
        for (Users u : userList) {
            if (u instanceof Customer) {
                Customer c = (Customer) u;
                System.out.println(c.name + "\t" + c.mobileNum + "\t" + c.account.balance);
            }
        }
        System.out.println("------------------------------------------------");
    }
    
    // Viewing of Specific Account
    public void viewSingleCust(Customer targetCust) {
        System.out.println("------------------------------------------------");
        System.out.println("\t\tACCOUNT RESULT");
        System.out.println("------------------------------------------------");
        System.out.println("FULL NAME\tMOBILE NUMBERS\tBALANCE");
        System.out.println(targetCust.name + "\t" + targetCust.mobileNum + "\t" + targetCust.account.balance);
        System.out.println("------------------------------------------------");
    }
}