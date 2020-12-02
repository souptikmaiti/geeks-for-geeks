public class _3_RotateBySwapBlock {

    static void printArray(int[] ar) {
        for (int j : ar)
            System.out.print(j + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] ar1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] ar2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] ar3 = new int[]{1, 3, 4, 2};
        printArray(ar1);
        rotateByRecursion(ar1, ar1.length, 2, 0);
        printArray(ar1);
        printArray(ar2);
        rotateByRecursion(ar2, ar2.length, 3, 0);
        printArray(ar2);
        printArray(ar3);
        rotateByRecursion(ar3, ar3.length, 3, 0);
        printArray(ar3);
    }

    static void rotateByIteration(int[] ar, int n, int d) {
        if (d == 0 || (d = d % n)==0)
            return;

        
    }

    static void rotateByRecursion(int[] ar, int n, int d, int i) {
        // 1,2(A)  ,3,4,5,6,7(B)
        // 1,2(A)  ,3,4,5(Bl), 6,7(Br)
        // 6,7(Br) ,3,4,5(Bl), 1,2(A)  swap A and Br
        //
        if (d == n - d) {
            swapBlock(ar, i, n - d + i, d);
            return;
        }

        if (d < n - d) {
            swapBlock(ar, i, n - d + i, d);
            rotateByRecursion(ar, n - d, d, i);
        }

        if (d > n - d) {
            swapBlock(ar, i, d, n - d);
            rotateByRecursion(ar, d, 2 * d - n, n - d + i);
        }
    }

    static void swapBlock(int[] ar, int first, int second, int size) {
        for (int i = 0; i < size; i++) {
            int tmp = ar[first + i];
            ar[first + i] = ar[second + i];
            ar[second + i] = tmp;
        }
    }
}
