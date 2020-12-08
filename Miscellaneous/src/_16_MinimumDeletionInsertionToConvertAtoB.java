// example: s1 = "heap", s2 = "pea", to convert a to b, we need to delete h and p from s1 and insert p to s1 at the beginning
// no. of deletion = 2 and no of insertion = 1
// s1 -> lcs -> s2
public class _16_MinimumDeletionInsertionToConvertAtoB {

    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";
        int n1 = s1.length();
        int n2 = s2.length();

        int lcs = lcsDynamic(s1, n1, s2, n2);

        System.out.println("No. of deletion: " + (n1 - lcs));
        System.out.println("No. of Insertion: " + (n2 - lcs));
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
