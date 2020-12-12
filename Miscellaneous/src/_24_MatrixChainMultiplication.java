// lets say we are given with 2 matrix X and Y with dimensions a*b and c*d
// they can be multiplied if and only if b == c
// The resultant matrix Z = X * Y will have dimension a*d
// the cost of multiplication (total # of multiplications) will be a*b*d or a*c*d


import java.util.Arrays;

// Problem Statement: we are given an array of matrix dimensions arr = {40, 20, 30, 10, 30}
// the matrices will be #len(arr) - 1 here 5-1=4 matrices are there
// matrix Ai will have dimension (arr[i-1] * a[i])
// find the minimum cost of all the possible ways to multiply Ai 's (i = 1 to n-1)
// (A1*A2)*A3*A4, A1*(A2*A3)*A4, A1*A2*(A3*A4) .....
public class _24_MatrixChainMultiplication {
    static int[][] t;

    public static void main(String[] args) {
        int[] arr = new int[]{40, 20, 30, 10, 30};
        t = new int[arr.length+1][arr.length+1];
        for (int[] row : t)
            Arrays.fill(row, -1);
        System.out.println(mcm(arr, 1, arr.length - 1));
    }

    public static int mcm(int[] arr, int i, int j) {
        if (i >= j)
            return 0;

        if (t[i][j] != -1) return t[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
             int tempAns = mcm(arr, i, k)
                    + arr[i-1] * arr[k] *arr[j]
                    + mcm(arr, k+1, j);

            ans = Math.min(ans, tempAns);
        }
        return t[i][j] = ans;
    }
}
