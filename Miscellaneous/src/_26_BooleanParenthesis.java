// lets say we are given with 2 matrix X and Y with dimensions a*b and c*d
// they can be multiplied if and only if b == c
// The resultant matrix Z = X * Y will have dimension a*d
// the cost of multiplication (total # of multiplications) will be a*b*d or a*c*d


import java.util.Arrays;

// Problem Statement: we are given a array containing strings which denote booleans T or F and operation & | and ^(xor) alternatively
// find no. of ways we can arrange the brackets so that result will be TRUE
public class _26_BooleanParenthesis {
    static int[][] t;

    public static void main(String[] args) {
        char[] arr = new char[]{'T', '|', 'F', '&', 'T', '^', 'F'};
        int n = arr.length;

        t = new int[n + 1][n + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

        System.out.println(mcm(arr, 0, n - 1)[0]);
        System.out.println(mcmBetter(arr, 0, n - 1, true));
    }

    public static int[] mcm(char[] arr, int i, int j) {
        int[] res = new int[2]; // 0, false
        if (i > j) {
            return res;
        }
        if (i == j) {
            res[0] = 1;
            if (arr[i] == 'T') res[1] = 1;
            else res[1] = 0;
            return res;
        }


        //if (t[i][j] != -1) return t[i][j];


        int[] ans = new int[2];  // 0, false

        for (int k = i; k <= j - 2; k += 2) {

            int[] left = mcm(arr, i, k) ;
            int[] right = mcm(arr, k+2, j);

            if (evaluate(left[1], right[1], arr[k+1])) {
                ans[0] += 1;
                ans[1] = 1;
            } else {
                ans[1] = 0;
            }
        }
        return ans;
    }

    static boolean evaluate(int l, int r, char op) {
        boolean ll = false, rr = false;
        if (l==1) ll = true;
        if (l==0) ll = false;

        if (r==1) rr = true;
        if (r==0) rr = false;
        if (op == '&')
            return ll && rr;
        if (op == '|')
            return ll || rr;
        if (op == '^')
            return ll ^ rr;
        return false;
    }

    public static int mcmBetter(char[] arr, int i, int j, boolean isTrue) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue) return arr[i] =='T'? 1: 0;
            else return  arr[i] =='F'? 1: 0;
        }


        //if (t[i][j] != -1) return t[i][j];


        int ans = 0;

        for (int k = i; k <= j - 2; k += 2) {

            int lTrue = mcmBetter(arr, i, k, true);
            int lFalse = mcmBetter(arr, i, k, false);
            int rTrue = mcmBetter(arr, k + 2, j, true);
            int rFalse = mcmBetter(arr, k + 2, j, false);

            switch (arr[k + 1]) {
                case '&' -> {
                    if (isTrue) ans += lTrue * rTrue;
                    else ans += lTrue  * rFalse + lFalse * rTrue + lFalse * rFalse;
                }
                case '|' -> {
                    if (isTrue) ans += lTrue * rTrue + lTrue * rFalse + lFalse * rTrue;
                    else ans += lFalse * rFalse;
                }
                case '^' -> {
                    if (isTrue) ans += lTrue * rFalse + lFalse * rTrue;
                    else ans += lTrue * rTrue + lFalse * rFalse;
                }
            }
        }
        return ans;
    }


}
