import java.util.Scanner;

public class Task7 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int sum = addition(num1, num2);
        System.out.println("Sum of two numbers: " + sum);

        int difference = subtraction(num1, num2);
        System.out.println("Difference of two numbers: " + difference);
        
        int quotient = division(num1, num2);
        System.out.println("Quotient of two numbers: " + quotient);
        
        int product = multiplication(num1, num2);
        System.out.println("Product of two numbers: " + product);

        sc.close();
    }

    public static int addition (int num1,int num2) {
        return num1 + num2;
    }

    public static int subtraction (int num1,int num2) {
        return num1 - num2;
    }

    public static int division (int num1,int num2) {
        return num1 / num2;
    }

    public static int multiplication (int num1,int num2) {
        return num1 * num2;
    }
}
