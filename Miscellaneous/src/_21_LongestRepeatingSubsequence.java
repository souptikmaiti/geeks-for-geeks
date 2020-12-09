// example: s = "aabebdcd", which is longest subsequence which repeats itself = abd
// ans len(abd) = 3
// we will find lcs for the same string except we will ignore when index is same and char is same
public class _21_LongestRepeatingSubsequence {

    public static void main(String[] args) {
        String s = "aabebdcd";
        int n = s.length();

        System.out.println(lcs(s, n, s, n));
    }

    public static int lcs(String s1, int n1, String s2, int n2) {
        int[][] dc = new int[n1 + 1][n2 + 1];

        for (int i = 1; i < n1 + 1; i++)
            dc[i][0] = 0;

        for (int j = 0; j < n2 + 1; j++)
            dc[0][j] = 0;

        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j)   // only change
                    dc[i][j] = 1 + dc[i - 1][j - 1];
                else
                    dc[i][j] = Math.max(dc[i-1][j], dc[i][j-1]);
            }
        }

        return dc[n1][n2];
    }
}
