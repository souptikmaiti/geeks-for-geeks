import java.util.Arrays;

// Problem Statement: Given a rod of some length and list of allowed cuts with their prices.
// Need to cut the rod so that price is maximum.
// Multiple occurrences of same cut is possible.. So its case of unbounded knapsack
public class _9_RodCuttingProblem {
    static int[][] t;

    public static void main(String[] args) {
        int[] lengthOfCuts = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] priceOfCuts = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int lengthOfRod = 8;
        int n = lengthOfCuts.length;

        // for Memoization
        t = new int[n + 1][lengthOfRod + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

        System.out.println(knapsack(lengthOfCuts, priceOfCuts, n, lengthOfRod));
        System.out.println(knapsackDynamic(lengthOfCuts, priceOfCuts, n, lengthOfRod));
    }

    public static int knapsack(int[] wt, int[] value, int n, int capacity) {
        if (n == 0 || capacity == 0)
            return 0;

        if (t[n][capacity] != -1)
            return t[n][capacity];

        if (wt[n-1] <= capacity) {
            return t[n][capacity] = Math.max(value[n - 1] + knapsack(wt, value, n, capacity - wt[n - 1]), // we choose the item
                    knapsack(wt, value, n - 1, capacity));  // we reject the item
        } else {
            return t[n][capacity] = knapsack(wt, value, n - 1, capacity);  // we reject the item as its weight is more than capacity
        }
    }

    public static int knapsackDynamic(int[] wt, int[] value, int n, int capacity) {
        int[][] dc = new int[n + 1][capacity + 1];

        for (int i = 0; i < n+1; i++)
            dc[i][0] = 0;

        for (int j = 1; j<capacity + 1; j++)
            dc[0][j] = 0;

        // exact same as recursion... only replace n with i and capacity with j
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < capacity + 1; j ++) {
                if (wt[i - 1] <= j)
                    dc[i][j] = Math.max((value[i-1] + dc[i][j-wt[i-1]]), dc[i-1][j]);
                else
                    dc[i][j] = dc[i-1][j];
            }

        return dc[n][capacity];
    }
}
