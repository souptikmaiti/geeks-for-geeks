public class _9_FindRotationCount {

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
        System.out.println(countRotationBinarySearch(ar1, 0, ar1.length - 1));
        printArray(ar2);
        System.out.println(countRotationBinarySearch(ar2, 0, ar2.length - 1));
        printArray(ar3);
        System.out.println(countRotationBinarySearch(ar3, 0, ar3.length - 1));
    }

    static int countRotation(int[] ar) {
        int len = ar.length;
        for (int i = 0; i < len - 1; i ++) {
            if (ar[i] > ar[i + 1])
                return i + 1;
        }
        return 0;
    }

    static int countRotationBinarySearch(int[] ar, int low, int high) {
        if (low > high)
            return 0;
        if (low == high)
            return low + 1;
        int mid = low + (low + high) / 2 ;

        if (mid < high && ar[mid] > ar[mid + 1])
            return mid + 1;
        if (mid > low && ar[mid - 1] > ar[mid])
            return mid;

        if (ar[high] > ar[mid])
            return countRotationBinarySearch(ar, low, mid - 1);

        return countRotationBinarySearch(ar, mid + 1, high);
    }
}
