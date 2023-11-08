import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        System.out.println("Enter the weights of the items: ");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.println("Enter the values of the items: ");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        System.out.print("Enter the knapsack capacity: ");
        int W = scanner.nextInt();

        int maxValue = knapsack(weights, values, n, W);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }

    public static int knapsack(int[] weights, int[] values, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }
}
