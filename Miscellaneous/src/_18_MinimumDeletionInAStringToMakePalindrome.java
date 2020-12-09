// example: s1 = "agbcba", palindromic subsequences = {aba, bcb, aa, bb, a, b, c, g, abba, abcba}
// longest is abcba... ans = # of deletion = 1 .. delete g to make s1 longest palindrome
public class _18_MinimumDeletionInAStringToMakePalindrome {

    public static void main(String[] args) {
        String s1 = "agbcba";
        String s2 = findReverse(s1);
        int n = s1.length();

        System.out.println("Minimum Number of Deletion to Make Palindrome: " + (n - lcsDynamic(s1, n, s2, n)));
    }

    public static String findReverse(String s) {
        String r = "";
        for (int i=s.length() - 1; i>=0; i--)
            r += s.charAt(i);
        return r;
    }

    public static int lcsDynamic(String s1, int n1, String s2, int n2) {
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
