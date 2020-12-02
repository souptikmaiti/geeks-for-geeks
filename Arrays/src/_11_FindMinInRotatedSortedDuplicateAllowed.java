public class _11_FindMinInRotatedSortedDuplicateAllowed {

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
        int[] ar1 = new int[]{5, 6, 1, 2, 3, 4};
        int[] ar2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] ar3 = new int[]{5, 6, 7, 8, 2, 2, 2, 3, 4};
        int[] ar4 = new int[]{5, 5, 6, 6, 7, 8, 2, 3, 3, 3, 4, 4};
        printArray(ar1);
        System.out.println(findMin(ar1, 0, ar1.length - 1));
        printArray(ar2);
        System.out.println(findMin(ar2, 0, ar2.length - 1));
        printArray(ar3);
        System.out.println(findMin(ar3, 0, ar3.length - 1));
        printArray(ar4);
        System.out.println(findMin(ar4, 0, ar4.length - 1));
    }

    static int findMin(int[] ar, int low, int high) {

        while (low < high) {
            int mid = (low + high) / 2;
            if (ar[mid] == ar[high])
                high --;
            else if (ar[mid] > ar[high])
                low = mid + 1;
            else if (ar[mid] < ar[high])
                high = mid;
        }
        return ar[high];
    }
}
