public class _4_RotateCyclicallyByOne {

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
        rotateCyclicallyByOne(ar1);
        printArray(ar1);
        printArray(ar2);
        rotateCyclicallyByOne(ar2);
        printArray(ar2);
        printArray(ar3);
        rotateCyclicallyByOne(ar3);
        printArray(ar3);
    }

    static void rotateCyclicallyByOne(int[] ar) {
        int len = ar.length;
        int tmp = ar[len - 1];
        for (int i = len - 1; i > 0; i--) {
            ar[i] = ar[i-1];
        }
        ar[0] = tmp;
    }
}
