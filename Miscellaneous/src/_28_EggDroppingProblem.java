// Problem Statement: given f floors and e eggs, find minimum no. of attempts to find out the threshold
// floor for worst case ( we don't have to find threshold floor, we need to find # of attempts)
// if k is the threshold floor, (egg will break for k to f floors and will not break for 0 to k-1 floors)

import java.util.Arrays;
public class _28_EggDroppingProblem {
    static int[][] t;

    public static void main(String[] args) {
        int e = 3;
        int f = 5;

        t = new int[e + 1][f + 1];
        for (int[] row : t)
            Arrays.fill(row, -1);

        System.out.println(eggDrop(e, f));
    }

    public static int eggDrop(int e, int f) {
        if (e == 1)
            return f;
        if (f == 1 || f==0)
            return f;

        if (t[e][f] != -1) return t[e][f];

        int min = Integer.MAX_VALUE;

        // I am in kth floor
        for (int k = 1; k <= f ; k++) {
            // we are selecting max for worst case
            int tmp = 1 + Math.max(eggDrop(e-1, k-1), // egg breaks, so check for lower floors
                    eggDrop(e, f-k));  // egg does not break, so check for higher floors

            min = Math.min(tmp, min);
        }

        return t[e][f] = min;
    }
}
