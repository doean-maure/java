import com.bank.models.*;
import java.util.List;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        List<Users> userList = List.of(
            new Admin(0, "09068845641", 3392, "Pat Pilar", "Manila", 34000, "admin"),
            new Customer(1, "09239834413", 1423, "Den De Guzman", "Mandaluyong", 1700, "customer"),
            new Customer(3, "09997843277", 9628, "Gil Maure", "Makati", 1400, "customer")); 
        
        boolean cont = true;

        while (cont) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter mobile number to Login: ");
            String inputMobileNum = sc.nextLine();
            System.out.println("Enter PIN: ");
            int inputPin = sc.nextInt();

            Users authenticateUser = null;

            for (Users u : userList) {
                if (u.getMobileNum().equals(inputMobileNum) && u.getPin()==inputPin) {
                    authenticateUser = u;
                    break;
                }
            }

            if (authenticateUser != null) {
                System.out.println("------------------------------------------------");
                System.out.println("Login Success.\nWelcome, " + authenticateUser.getName() + "!");
                System.out.println("------------------------------------------------");
                
                boolean running = true;
                while (running) {
                    if (authenticateUser instanceof Customer) {
                        Customer currentCust = (Customer) authenticateUser;
                        System.out.println("\n1. Check Balance  2. Cash-in  3. Transfer Money  4. Withdraw  5. History  6. Logout");
                        int choice = sc.nextInt();
                        if (choice == 1) { // Check Balance
                            System.out.println("------------------------------------------------");
                            System.out.println("\t\tCHECKING BALANCE");
                            System.out.println("------------------------------------------------");
                            currentCust.account.balance();
                        } else if (choice == 2) { // Cash-in 
                            System.out.println("------------------------------------------------");
                            System.out.println("\t\t    CASH-IN");
                            System.out.println("------------------------------------------------");
                            System.out.print("Amount: ");
                            currentCust.account.deposit(sc.nextDouble(),currentCust.getRole(),currentCust.getName());
                        } else if(choice == 3) { // Transfer Money
                            System.out.println("------------------------------------------------");
                            System.out.println("\t\tTRANSFER MONEY");
                            System.out.println("------------------------------------------------");
                            System.out.print("Mobile Number: ");
                            String receiverNum = sc.next();
                            boolean sameMobileNum = currentCust.getMobileNum().equals(receiverNum);
                            Customer validReceiver = null;
                            for (Users u : userList) {
                                if (sameMobileNum != true && u.getRole().equals("Customer") && u.getMobileNum().equals(receiverNum)) {
                                    validReceiver = (Customer)u;
                                    break;
                                } 
                            }
                            if (validReceiver != null) {
                                System.out.print("Amount: ");
                                currentCust.account.transferMoney(validReceiver.account,sc.nextDouble(),currentCust.getName(),validReceiver.getName());
                            } else {
                                System.out.println("------------------------------------------------");
                                System.out.println("Invalid Number");
                                System.out.println("------------------------------------------------"); 
                            }      
                        } else if(choice == 4) { // Withdraw
                            System.out.println("------------------------------------------------");
                            System.out.println("\t\tWITHDRAW MONEY");
                            System.out.println("------------------------------------------------");
                            System.out.print("Amount: ");
                            currentCust.account.withdraw(sc.nextDouble(),currentCust.getRole(),currentCust.getName());
                        } else if(choice == 5) { // History
                            System.out.println("------------------------------------------------");
                            System.out.println("\t\tTRANSACTION HISTORY");
                            System.out.println("------------------------------------------------");
                            currentCust.account.showHistory(currentCust.getName(),currentCust.getMobileNum());
                        } else if(choice == 6) { // Logout
                            running = false;
                            System.out.println("------------------------------------------------");
                            System.out.println("\tYour account has been logged out.");
                            System.out.println("------------------------------------------------");
                            
                            boolean y = false;
                                
                            while (!y) {
                                System.out.println("\nDo you want to login?(y/n)");
                                String ans = sc.next();
                                if (ans.equalsIgnoreCase("y")) {
                                    y = true;
                                } else if (ans.equalsIgnoreCase("n")) {
                                    y = true;
                                    cont = false;
                                }
                            }
                        } 
                    } else if (authenticateUser instanceof Admin) {
                        Admin currentAdmin = (Admin) authenticateUser;
                        System.out.println("Welcome Admin! System stats: " + userList.size() + " users found.");
                        while (running) {
                            System.out.println("\n1. View All Balance   2. View Specific Account   3. Add Fund   4. Deduct Fund   5. Logout");
                            int choice = sc.nextInt();
                            if (choice == 1) { //View All Users' Balance
                                currentAdmin.viewAllBalances(userList);
                            } else if (choice == 2 || choice == 3 || choice == 4) { //2. View Specific Account 3. Add Fund 4. Deduct Fund
                                if (choice == 2) {
                                    System.out.println("------------------------------------------------");
                                    System.out.println("\t\tVIEW ACCOUNT");
                                    System.out.println("------------------------------------------------");
                                } else if (choice == 3) {
                                    System.out.println("------------------------------------------------");
                                    System.out.println("\t\tADD FUNDS");
                                    System.out.println("------------------------------------------------");
                                } else if (choice == 4) {
                                    System.out.println("------------------------------------------------");
                                    System.out.println("\t\tDEDUCT FUNDS");
                                    System.out.println("------------------------------------------------");        
                                }
                                System.out.print("Mobile Number: ");
                                String custMobileNum = sc.next();
                                Customer targetCust = null;
                                for (Users u : userList) {
                                    if (u.getMobileNum().equalsIgnoreCase(custMobileNum) && u instanceof Customer) {
                                        targetCust = (Customer) u;
                                        break;
                                    }
                                }
                                if (targetCust != null) {
                                    if (choice == 2) {
                                        currentAdmin.viewSingleCust(targetCust);
                                    } else { 
                                        System.out.print("Amount: ");
                                        if (choice == 3) {
                                            targetCust.account.deposit(sc.nextDouble(),currentAdmin.getRole(),targetCust.getName());
                                        } else if (choice == 4){ //
                                            targetCust.account.withdraw(sc.nextDouble(),currentAdmin.getRole(),targetCust.getName());
                                        }
                                    }
                                } else if (targetCust == null) { 
                                    System.out.println("------------------------------------------------");
                                    System.out.println("Invalid Number");
                                    System.out.println("------------------------------------------------");
                                } 
                            } else if (choice == 5){ 
                                running = false;
                                System.out.println("------------------------------------------------");
                                System.out.println("\tYour account has been logged out.");
                                System.out.println("------------------------------------------------");
                                
                                boolean y = false;
                                
                                while (!y) {
                                    System.out.println("\nDo you want to login?(y/n)");
                                    String ans = sc.next();
                                    if (ans.equalsIgnoreCase("y")) {
                                        y = true;
                                    } else if (ans.equalsIgnoreCase("n")) {
                                        y = true;
                                        cont = false;
                                    }
                                }   
                            } 
                        }   
                    }   
                }
            } else {
                System.out.println("------------------------------------------------");
                System.out.println("Error: User not found or incorrect pin");
                System.out.println("------------------------------------------------");
            } 
        } 
    }
}
