import java.util.Arrays;

// Problem Statement: Given 2 strings we need to find length of longest common substring
// example: s1 = "abcde", s2 = "abfce", substrings = {"ab", "c", "e"}. So ans = length("ab") = 2
public class _13_LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        int n1 = s1.length();
        int n2 = s2.length();

        System.out.println(lcSubstringDynamic(s1, n1, s2, n2));
        System.out.println(lcSubstringRecursion(s1, n1, s2, n2, 0));
    }

    public static int lcSubstringDynamic(String s1, int n1, String s2, int n2) {
        int[][] dc = new int[n1 + 1][n2 + 1];

        for (int i = 1; i < n1 + 1; i++)
            dc[i][0] = 0;

        for (int j = 0; j < n2 + 1; j++)
            dc[0][j] = 0;

        int max = 0;
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dc[i][j] = 1 + dc[i - 1][j - 1];
                else
                    dc[i][j] = 0;

                max = Math.max(max, dc[i][j]);
            }
        }
        return max;
    }

    public static int lcSubstringRecursion(String s1, int n1, String s2, int n2, int count) {
        if (n1 == 0 || n2 == 0)
            return count;

        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1))
            count = lcSubstringRecursion(s1, n1 - 1, s2, n2 - 1, count + 1);
        else
            count = Math.max(lcSubstringRecursion(s1, n1, s2, n2 - 1, 0), lcSubstringRecursion(s1, n1 - 1, s2, n2, 0));
        return count;
    }
}
