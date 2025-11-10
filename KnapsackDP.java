import java.util.Scanner;
public class KnapsackDP {
    // Function to solve 0/1 Knapsack using Dynamic Programming
    static int knapsack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        System.out.println("Enter values and weights of items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            val[i] = sc.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            wt[i] = sc.nextInt();
        }

        System.out.print("Enter maximum capacity of knapsack: ");
        int W = sc.nextInt();

        System.out.println("\nMaximum value in knapsack = " + knapsack(W, wt, val, n));
        sc.close();
    }
}
