import java.util.ArrayList;

public class Task8 {

public static ArrayList<Integer> printNumber(int... numbers) {
    ArrayList<Integer> results = new ArrayList<>();
    
    for (int n : numbers) {
        int total = 0;
        for (int i = 1; i<=n; i++) {
            total += i;
        }
        results.add(total);
    }
    return results; 
}
    
public static void main(String[] args) {

        ArrayList<Integer> output = printNumber(4,5,10);
        System.out.println(output);
    }
}

