import java.util.Arrays;

// Problem Statement: Given a list of possible coins and a Sum. Supply of coins is unlimited
// Need to find no. of ways the coins can sum up to given Sum
// Multiple occurrences of same coin is possible.. So its a variation of unbounded knapsack
public class _10_CoinChangeMaximumWays {
    static int[][] t;

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        int sum = 10;
        int n = coins.length;

        // for Memoization
        t = new int[n + 1][sum + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

        System.out.println(coinSumWays(coins, n, sum));
        System.out.println(myVersionRecursion(coins, n, sum));
        System.out.println(coinSumWaysDynamic(coins, n, sum));
    }

    public static int coinSumWays(int[] coins, int n, int sum) {
        if (sum == 0)
            return 1;
        if (n == 0 && sum > 0)
            return 0;

        if (t[n][sum] != -1)
            return t[n][sum];

        if (coins[n-1] <= sum)
            return t[n][sum] = coinSumWays(coins, n, sum - coins[n - 1])
                     + coinSumWays(coins, n - 1, sum);
        else
            return t[n][sum] = coinSumWays(coins, n - 1, sum);
    }

    public static int myVersionRecursion(int[] coins, int n, int sum) {
        if (sum == 0)
            return 1;
        if (n == 0 && sum > 0)
            return 0;

        if (t[n][sum] != -1)
            return t[n][sum];

        int count = 0;
        if (coins[n-1] == sum)
            count += 1;
        if (coins[n-1] <= sum)
            count += coinSumWays(coins, n, sum - coins[n - 1])
                    + coinSumWays(coins, n - 1, sum);
        else
            count += coinSumWays(coins, n - 1, sum);
        return t[n][sum] = count;
    }

    public static int coinSumWaysDynamic(int[] coins, int n, int sum) {
        int[][] dc = new int[n + 1][sum + 1];

        for (int i = 0; i < n+1; i++)
            dc[i][0] = 1;

        for (int j = 1; j<sum + 1; j++)
            dc[0][j] = 0;

        // exact same as recursion... only replace n with i and capacity with j
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < sum + 1; j ++) {
                if (coins[i - 1] <= j)
                    dc[i][j] = dc[i][j-coins[i-1]] + dc[i-1][j];
                else
                    dc[i][j] = dc[i-1][j];
            }

        return dc[n][sum];
    }
}
