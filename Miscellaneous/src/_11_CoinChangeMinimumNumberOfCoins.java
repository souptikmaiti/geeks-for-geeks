import java.util.Arrays;

// Problem Statement: Given a list of possible coins and a Sum. Supply of coins is unlimited
// Need to find minimum no. of coins that sum up to given Sum
// Multiple occurrences of same coin is possible.. So its a variation of unbounded knapsack
// example: coins = {1, 2, 3}, Sum = 5, possible ways = {1,1,1,1,1}, {1,1,1,2}, {1,1,3}, {2,3} and {2,2,1}
// among these {2,3} needs minimum no. of coins. So ans = 2
public class _11_CoinChangeMinimumNumberOfCoins {
    static int[][] t;

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        int sum = 10;
        int n = coins.length;

        // for Memoization
        t = new int[n + 1][sum + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

        System.out.println(minimumCoins(coins, n, sum));
        System.out.println(minimumCoinDynamic(coins, n, sum));
    }

    public static int minimumCoins(int[] coins, int n, int sum) {
        if (sum == 0 && n > 0)
            return 0;
        if (n == 0)
            return Integer.MAX_VALUE - 1;  // if we add 1 to Int.MAX it becomes -ve
        if (n == 1)
            if (sum % coins[0] == 0) return sum / coins[0];
            else return Integer.MAX_VALUE - 1;

        if (t[n][sum] != -1)
            return t[n][sum];

        if (coins[n-1] <= sum)
            return t[n][sum] = Math.min(1 + minimumCoins(coins, n, sum - coins[n - 1]), // here we are adding 1 as we are including the coin
                    minimumCoins(coins, n - 1, sum));
        else
            return t[n][sum] = minimumCoins(coins, n - 1, sum);
    }

    public static int minimumCoinDynamic(int[] coins, int n, int sum) {
        int[][] dc = new int[n + 1][sum + 1];

        for (int j = 0; j<sum + 1; j++)
            dc[0][j] = Integer.MAX_VALUE - 1;

        for (int i = 1; i < n+1; i++)
            dc[i][0] = 0;

       for (int j = 1; j< sum + 1; j++)
           if (j % coins[0] == 0) dc[0][j] = j / coins[0];
           else dc[0][j] = Integer.MAX_VALUE - 1;

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < sum + 1; j ++) {
                if (coins[i - 1] <= j)
                    dc[i][j] = Math.min(1 + dc[i][j-coins[i-1]], dc[i-1][j]);
                else
                    dc[i][j] = dc[i-1][j];
            }

        return dc[n][sum];
    }
}
