public class _1_Rotate {

    static void printArray(int[] ar) {
        for (int j : ar)
            System.out.print(j + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1, 2, 3, 4, 5, 6, 7};
        printArray(ar);
        //rotateUsingTemp(ar, 2);
        rotateByN(ar, 3);
        printArray(ar);
    }

    // requires extra an array
    static void rotateUsingTemp(int[] ar, int d) {
        int[] tmp = new int[d];
        int arlen = ar.length;
        int tmplen = tmp.length;

        for (int i = 0; i < d; i++)
            tmp[i] = ar[i];

        for (int i = d; i < arlen; i++)
            ar[i - d] = ar[i];

        for (int i = 0; i < tmplen; i++)
            ar[arlen - tmplen + i] = tmp[i];
    }

    static void rotateByN(int[] ar, int n) {
        for (int i = 0; i < n; i++)
            rotateBy1(ar);
    }

    // in place but complexity O(d*n)
    static void rotateBy1(int[] ar) {
        int tmp = ar[0];
        int arlen = ar.length;
        for (int i = 0; i < arlen - 1; i++)
            ar[i] = ar[i + 1];
        ar[arlen - 1] = tmp;
    }
}
