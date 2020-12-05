import java.util.Arrays;

public class _5_CountOfSubsetSum {

    public static void main(String[] args) {
        int[] ar = new int[]{2, 3, 5, 6, 8, 10};
        //int sum = 10;
        //int sum = 13;
        //int sum = 24;
        int sum = 30;
        System.out.println(findSubsetCountDynamic(ar, ar.length, sum));
        System.out.println(findSubsetCountRec(ar, ar.length, sum));
    }

    public static int findSubsetCountRec(int[] ar, int n, int sum) {
        if (n >=0 && sum == 0) return 1;
        if (n == 0 && sum > 0) return 0;

        if (ar[n-1] <= sum)
            return findSubsetCountRec(ar, n-1, sum - ar[n-1]) + findSubsetCountRec(ar, n-1, sum);
        else
            return findSubsetCountRec(ar, n-1, sum);
    }

    public static int findSubsetCountDynamic(int[] ar, int n, int sum) {
        int[][] dc = new int[n + 1][sum + 1];
        for (int i = 0; i < n+1; i++)  // if sum = 0 and we have/ have not any array element we can return null set as subset
            dc[i][0] = 1;

        for (int j = 1; j<sum + 1; j++)  // if we dont have any element in array and sum > 0 we can't return any subset
            dc[0][j] = 0;

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < sum + 1; j ++) {
                if (ar[i - 1] <=  j)
                    dc[i][j] = dc[i -1][j - ar[i -1]] + dc[i -1][j];
                else
                    dc[i][j] = dc[i - 1][j];
            }

        return dc[n][sum];
    }
}
