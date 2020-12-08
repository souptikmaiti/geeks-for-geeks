// Problem Statement: Given 2 strings we need to find length of shortest supersequence
// example: s1 = "aabcde", s2 = "abbfceg", simple super seq = "aabcdeabbfceg" written 2 seq one after another
// now we will write the char once which are common to both and shortest superstring = "aabbfcdeg" i.e,
// ans = len(s1) + len(s2) - lcs(s1, s2)
public class _15_ShortestCommonSupersequence {

    public static void main(String[] args) {
        String s1 = "aabcde";
        String s2 = "abbfceg";
        int n1 = s1.length();
        int n2 = s2.length();

        System.out.println(n1 + n2 -lcsDynamic(s1, n1, s2, n2));
    }

    public static int lcsDynamic(String s1, int n1, String s2, int n2) {
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
                    dc[i][j] = Math.max(dc[i-1][j], dc[i][j-1]);

                max = Math.max(max, dc[i][j]);
            }
        }
        return dc[n1][n2];
    }
}
