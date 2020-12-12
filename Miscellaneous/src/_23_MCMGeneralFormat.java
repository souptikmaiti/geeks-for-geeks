// Matrix Chain Multiplication
// General Format: input: {array/string, 0, len(array)}
// we will break the array into 2 parts i->k and k+1->j where k will vary from i to j
// we wiil store the temporary ans of the recursive calls
// finally after some operation on temp ans will return it
public class _23_MCMGeneralFormat {

    public static void main(String[] args) {

    }

    public static int mcm(int[] arr, int i, int j) {
        if (i > j)
            return 0;

        int ans = 0;

        for (int k = i; k <j; k++) {       // depend on specific question
            int tempAns = mcm(arr, i, k)
                    +                      // depend on specific question
                    mcm(arr, k+1, j);

            ans = someFuction(tempAns);  // depend on specific question

        }
        return ans;
    }

    private static int someFuction(int tempAns) {
        return tempAns;
    }
}
