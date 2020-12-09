// example: s1 = "axy", s2 = "adxcpy"... s1 is a subsequence of s2. ans = true
// example: s1 = "axy", s2 = "adycpx"... s1 is a not subsequence of s2. ans = false
public class _22_SequencePatternMatching {

    public static void main(String[] args) {
        String s1 = "axy";
        String s2 = "adxcpy";
        int n1 = s1.length();
        int n2 = s2.length();

        System.out.println(n1 == lcs(s1, n1, s2, n2));
    }

    public static int lcs(String s1, int n1, String s2, int n2) {
        int[][] dc = new int[n1 + 1][n2 + 1];

        for (int i = 1; i < n1 + 1; i++)
            dc[i][0] = 0;

        for (int j = 0; j < n2 + 1; j++)
            dc[0][j] = 0;

        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dc[i][j] = 1 + dc[i - 1][j - 1];
                else
                    dc[i][j] = Math.max(dc[i-1][j], dc[i][j-1]);
            }
        }

        return dc[n1][n2];
    }
}
