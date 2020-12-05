import java.util.Arrays;

// Problem Statement: if 2 subsets(mutually exclusive and 2 results the entire array) of an array gives same sum
public class _4_EqualSumPartitionProblem {
    public static void main(String[] args) {
        int[] ar1 = new int[]{1, 5, 11, 5};
        int[] ar2 = new int[]{2, 4, 1, 3, 10};
        int[] ar3 = new int[]{2, 4, 1, 3, 12};
        System.out.println(isEqualSumPartitionPossible(ar2));
    }

    public static boolean isEqualSumPartitionPossible(int[] ar) {
        int total = 0;
        int len = ar.length;
        for (int i = 0; i<len; i++)
            total += ar[i];

        // if total of all elements of the array is odd, not possible to break up array into equal sum
        // if total of all elements of the array is even, if we can find out if there exists a subset with sum = total/2
        // then by default, the rest elements sums up to total/2
        if (total % 2 != 0) return false;
        else return findSubsetDynamic(ar, len, total / 2);
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
