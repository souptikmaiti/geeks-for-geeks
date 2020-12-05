import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class _3_SubsetSumProblem {
    static int[][] t;
    public static void main(String[] args) {
        int[] ar = new int[]{2, 3, 7, 8, 15};
        int sum = 14;
        int n = ar.length;
        t = new int[n + 1][sum + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);
        //System.out.println(findSubset(ar, ar.length, sum));
        System.out.println(findSubsetDynamic(ar, ar.length, sum));
    }

    public static boolean findSubset(int[] ar, int n, int sum) {
        if (n == 0)
            return false;

        if (t[n][sum] != -1) return t[n][sum] == 1;

        if (ar[n-1] == sum) {
            t[n][sum] = 1;
            return true;
        }else if (ar[n-1] < sum) {
            boolean flag = findSubset(ar, n-1, sum - ar[n-1]) || findSubset(ar, n-1, sum);
            if (flag) t[n][sum] = 1;
            else t[n][sum] = 0;
            return flag;
        } else {
            boolean flag = findSubset(ar, n-1, sum);
            if (flag) t[n][sum] = 1;
            else t[n][sum] = 0;
            return flag;
        }
    }

    public static boolean findSubsetDynamic(int[] ar, int n, int sum) {
        boolean[][] dc = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n+1; i++)  // if sum = 0 and we have/ have not any array element we can return null set as subset
            dc[i][0] = true;

        for (int j = 1; j<sum + 1; j++)  // if we dont have any element in array and sum > 0 we can't return any subset
            dc[0][j] = false;

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < sum + 1; j ++) {
                if (ar[i - 1] == j)
                    dc[i][j] = true;
                else if (ar[i - 1] < j)
                    dc[i][j] = dc[i -1][j - ar[i -1]] || dc[i -1][j];
                else
                    dc[i][j] = dc[i - 1][j];
            }

        return dc[n][sum];
    }
}
