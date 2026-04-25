import java.util.Scanner;
    
public class Activity1 {
      boolean cont;
    public static void main(String[] args) {
        
        boolean cont = true;    
        Scanner sc = new Scanner(System.in); 

        while (cont) {
            System.out.println("Enter three numbers: ");
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int num3 = sc.nextInt();

                if (num1 == num2 && num3 == num1) 
                    System.out.println("All numbers are equals.");
                else if (num1 >= num2 && num3 <= num2) 
                    System.out.println("The largest number is " + num1);
                else if (num2 >= num3 && num1 < num2) 
                    System.out.println("The largest number is " + num2);
                else if (num3 >= num1 && num2 < num3) 
                    System.out.println("The largest number is " + num3); 

            System.out.println("Do you want to continue? (y/n)");
            String input = sc.next();
            boolean answer = input.equalsIgnoreCase("Y");
            cont = answer;
        }
        
        sc.close();
        System.out.println("Thank you.");   
    }        
}