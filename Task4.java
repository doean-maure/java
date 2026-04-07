import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        StringBuilder inputString = new StringBuilder(input);
        StringBuilder reversedString = inputString.reverse();
        boolean isPalindrome = input.equals(reversedString.toString());
        sc.close();

        if (isPalindrome) {
            System.out.println("The input string is a palindrome");
        } else System.out.println("The input string is not a palindrome");

    }
}