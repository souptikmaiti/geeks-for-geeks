// lets say we are given with 2 matrix X and Y with dimensions a*b and c*d
// they can be multiplied if and only if b == c
// The resultant matrix Z = X * Y will have dimension a*d
// the cost of multiplication (total # of multiplications) will be a*b*d or a*c*d


import java.util.Arrays;

// Problem Statement: we are given a String
// find minimum no. of partitions so that all substrings become palindrome
public class _25_PalindromePartitioning {
    static int[][] t;

    public static void main(String[] args) {
        String str = "njitin";
        int n = str.length();

        t = new int[n + 1][n + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

        System.out.println(mcm(str, 0, n - 1));
    }

    public static int mcm(String str, int i, int j) {
        if (i >= j)
            return 0;

        if (t[i][j] != -1) return t[i][j];

        if (isPalindrome(str, i, j)) return 0;

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {

            // further optimization, we will not call mcm if it is already present
            int left, right = 0;
            if (t[i][k] != -1) left = t[i][k];
            else left = t[i][k] = mcm(str, i, k);
            if (t[k + 1][j] != -1) right = t[k + 1][j];
            else right = t[k + 1][j] = mcm(str, k+1, j);

            int tempAns = left
                    + 1
                    + right;

            ans = Math.min(ans, tempAns);
        }
        return t[i][j] = ans;
    }

    static boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else
                return false;
        }
        return true;
    }
}
