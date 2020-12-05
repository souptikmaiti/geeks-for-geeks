import java.util.Vector;

public class _7_CountOfSubsetPairWithGivenDifference {

    //Problem Statement: S1 = sum of subset 1
    // S2 = sum of rest subset
    // find count(abs(S1 - S2) = diff)
    public static void main(String[] args) {
        int[] ar = new int[]{1, 1, 2, 3};
        int diff = 1;
        System.out.println(countSubsetPairs(ar, diff));
    }

    public static int countSubsetPairs(int[] ar, int diff) {
        // S1 - S2 = diff
        // S1 + S2 = total
        // => 2S1 = diff + total
        // => S1 = (diff + total) / 2

        int total = findTotal(ar);
        if ((diff + total)%2 != 0) return 0;
        else return findSubsetCountDynamic(ar, ar.length, (diff + total)/2);
    }

    public static int findTotal(int[] ar) {
        int len = ar.length;
        int total = 0;
        for (int i =0; i<len; i++)
            total += ar[i];
        return total;
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
