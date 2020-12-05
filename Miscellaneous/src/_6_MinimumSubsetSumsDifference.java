import java.util.Vector;

public class _6_MinimumSubsetSumsDifference {

    //Problem Statement: S1 = sum of subset 1
    // S2 = sum of rest subset
    // find min(abs(S1 - S2))
    public static void main(String[] args) {
        int[] ar = new int[]{2, 3, 5, 6, 8, 10};
        System.out.println(findMinDifferenceOfSubsetSums(ar));
    }

    public static int findMinDifferenceOfSubsetSums(int[] ar) {
        int total = findTotal(ar);
        boolean[] lastRow = findAllPossibleSubsetSum(ar, ar.length, total);
        Vector<Integer> possibleS1s = new Vector<>();
        for (int i = 0; i < lastRow.length/2; i++)
            if (lastRow[i])
                possibleS1s.add(i);
        return total - 2*possibleS1s.lastElement();
    }

    public static int findTotal(int[] ar) {
        int len = ar.length;
        int total = 0;
        for (int i =0; i<len; i++)
            total += ar[i];
        return total;
    }

    public static boolean[] findAllPossibleSubsetSum(int[] ar, int n, int sum) {
        boolean[][] dc = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n+1; i++)  // if sum = 0 and we have/ have not any array element we can return null set as subset
            dc[i][0] = true;

        for (int j = 1; j<sum + 1; j++)  // if we dont have any element in array and sum > 0 we can't return any subset
            dc[0][j] = false;

        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < sum + 1; j ++) {
                if (ar[i - 1] <=  j)
                    dc[i][j] = dc[i -1][j - ar[i -1]] || dc[i -1][j];
                else
                    dc[i][j] = dc[i - 1][j];
            }

        return dc[n]; // last row of the table will give me possible sum of subsets
    }
}
