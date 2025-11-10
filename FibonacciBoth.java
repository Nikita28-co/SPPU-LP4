import java.util.Scanner;

public class FibonacciBoth {

    static int recursiveSteps = 0;
    static int iterativeSteps = 0;

    // Recursive Fibonacci Function
    static int recursiveFibonacci(int n) {
        recursiveSteps++;
        if (n <= 1)
            return n;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }
    // Iterative Fibonacci Function
    static void iterativeFibonacci(int n) {
        int a = 0, b = 1, c;
        System.out.print("Iterative Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            iterativeSteps++;
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms (n): ");
        int n = sc.nextInt();

        // Iterative approach
        iterativeFibonacci(n);
        System.out.println("Iterative Steps: " + iterativeSteps);

        // Recursive approach
        System.out.print("\nRecursive Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(recursiveFibonacci(i) + " ");
        }
        System.out.println("\nRecursive Steps: " + recursiveSteps);

        sc.close();

        // Complexity summary
        System.out.println("\n--- Complexity Analysis ---");
        System.out.println("Iterative: Time = O(n), Space = O(1)");
        System.out.println("Recursive: Time = O(2^n), Space = O(n)");
    }
}
