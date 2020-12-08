// Problem Statement: Given 2 strings we need to find length of longest common substring
// example: s1 = "abcde", s2 = "abfce", substrings = {"ab", "c", "e"}. So ans = length("ab") = 2
public class _14_PrintLongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int n1 = s1.length();
        int n2 = s2.length();

        printLongestCommonSubsequence(s1, n1, s2, n2);
    }

    public static void printLongestCommonSubsequence(String s1, int n1, String s2, int n2) {
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

        // Now starting from dc[n1][n2] backtrack the matrix according to the following rule

        String str = "";

        int i = n1, j = n2;

        while (i != 0 && j != 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                str += s1.charAt(i - 1);
                i--;
                j--;
            }
            else {
                if (dc[i-1][j] > dc[i][j-1]) {
                    i--;
                } else if (dc[i][j-1] > dc[i-1][j]) {
                    j--;
                } else {
                    i--;
                    j--;
                }
            }
        }

        System.out.println(str);
        for (int k =str.length() - 1; k>=0; k--)
            System.out.print(str.charAt(k));
    }
}
