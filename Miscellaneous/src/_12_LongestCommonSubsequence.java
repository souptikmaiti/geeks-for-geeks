import java.util.Arrays;

// Problem Statement: Given 2 strings we need to find length of longest common subsequence(lcs)
// don't confuse with substring which has to continuous, but subsequence might not be continuous
// example: s1 = "abcdgh", s2 = "abedfhr", lcs = "abdh". So ans = 4
public class _12_LongestCommonSubsequence {
    static int[][] t;

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int n1 = s1.length();
        int n2 = s2.length();

        // for Memoization
        t = new int[n1 + 1][n2 + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

        System.out.println(lcsRecursion(s1, n1, s2, n2));
        System.out.println(lcsDynamic(s1, n1, s2, n2));
    }

    public static int lcsRecursion(String s1, int n1, String s2, int n2) {
        if (n1 == 0 || n2 == 0)
            return 0;
        if (t[n1][n2] != -1) return t[n1][n2];

        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1))
            return t[n1][n2] = 1 + lcsRecursion(s1, n1 - 1, s2, n2 - 1);
        else
            return t[n1][n2] = Math.max(lcsRecursion(s1, n1, s2, n2 - 1), lcsRecursion(s1, n1 - 1, s2, n2));
    }

    public static int lcsDynamic(String s1, int n1, String s2, int n2) {
        int[][] dc = new int[n1 + 1][n2 + 1];

        for (int i = 1; i < n1 + 1; i++)
            dc[i][0] = 0;

        for (int j = 0; j < n2 + 1; j++)
            dc[0][j] = 0;


        for (int i = 1; i < n1 + 1; i++)
            for (int j = 1; j < n2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dc[i][j] = 1 + dc[i - 1][j-1];
                else
                    dc[i][j] = Math.max(dc[i][j-1], dc[i-1][j]);
            }
        return dc[n1][n2];
    }
}
