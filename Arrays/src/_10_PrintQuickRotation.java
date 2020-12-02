public class _10_PrintQuickRotation {

    static void printArray(int[] ar) {
        if (ar == null) {
            System.out.println("Not Found");
            return;
        }
        for (int j : ar)
            System.out.print(j + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] ar1 = new int[]{15, 18, 2, 3, 6, 12};
        int[] ar2 = new int[]{7, 9, 11, 12, 5};
        int[] ar3 = new int[]{7, 9, 11, 12, 15};
        printArray(ar1);
        printRotation(ar1, 2);
        printArray(ar2);
        printRotation(ar2, 6);
        printArray(ar3);
        printRotation(ar3, 3);
    }

    static void printRotation(int[] ar, int d) {
        int len = ar.length;
        for (int i = d; i < d + len; i ++)
            System.out.print(ar[i % len] + " ");
        System.out.println("");
    }
}
