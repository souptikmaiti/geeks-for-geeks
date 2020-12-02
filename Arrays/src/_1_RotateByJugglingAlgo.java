public class _1_RotateByJugglingAlgo {

    static void printArray(int[] ar) {
        for (int j : ar)
            System.out.print(j + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] ar1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        printArray(ar);
        rotateByJuggling(ar, 3);
        printArray(ar);
        printArray(ar1);
        rotateByJuggling(ar1, 2);
        printArray(ar1);
    }

    static void rotateByJuggling(int[] ar, int d) {
        int len = ar.length;
        d = d % len; //if d is greater than length
        int gcd = getGcd(len, d);
        int k, j, tmp;
        for (int i =0; i<gcd; i++) {
            tmp = ar[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= len)
                    k = k - len;
                if (k == i)
                    break;
                ar[j] = ar[k];
                j = k;
            }
            ar[j] = tmp;
        }

    }

    static int getGcd(int a, int b) {
        int min = a > b ? b : a;
        int res = 1;
        for (int i = 1; i <= min ; i++) {
            if (a % i == 0 && b % i == 0)
                res = i;
        }
        return res;
    }
}
