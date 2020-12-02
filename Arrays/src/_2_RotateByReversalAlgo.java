public class _2_RotateByReversalAlgo {

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
        rotateByReversal(ar1, 2);
        printArray(ar1);
        printArray(ar2);
        rotateByReversal(ar2, 3);
        printArray(ar2);
        printArray(ar3);
        rotateByReversal(ar3, 999);
        printArray(ar3);
    }

    static void rotateByReversal(int[] ar, int d) {
        d = d % ar.length;
        reverseByRange(ar, 0, d-1);   // 2,1  ,3,4,5,6,7
        reverseByRange(ar, d, ar.length - 1);  // 2,1  ,7,6,5,4,3
        reverseByRange(ar, 0, ar.length -1 );  // 3,4,5,6,7,1,2
    }

    static void reverseByRange(int[] ar, int start, int end) {
        if (start >= end)
            return;
        while (start < end) {
            int tmp = ar[start];
            ar[start] = ar[end];
            ar[end] = tmp;
            start ++;
            end --;
        }
    }
}
