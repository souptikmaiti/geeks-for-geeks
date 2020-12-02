public class _5_BinarySearchInRotatedArray {

    static void printArray(int[] ar) {
        for (int j : ar)
            System.out.print(j + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] ar1 = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
        int[] ar2 = new int[]{30, 40, 50, 10, 20};
        printArray(ar1);
        System.out.println(searchInRotatedArray(ar1, 8));

        printArray(ar2);
        System.out.println(searchInRotatedArray(ar2, 10));

    }

    static int searchInRotatedArray(int[] ar, int key) {
        int pivot = findPivot(ar);
        return searchBinary(ar, 0, pivot, key) != -1 ? searchBinary(ar, 0, pivot, key) : searchBinary(ar, pivot +1, ar.length -1, key);
    }

    static int findPivot(int[] ar) {
        int i;
        for (i = 0; i<ar.length - 1; i++) {
            if (ar[i] > ar[i+1])
                return i;
        }
        return i;
    }

    static int searchBinary(int[] ar, int low, int high, int key) {
        if (low <= high) {

            if (low == high) {
                if (ar[low] == key)
                    return low;
                return -1;
            }
            int mid = (high + low - 1) / 2;

            if (key == ar[mid])
                return mid;
            if (key < ar[mid])
                return searchBinary(ar, low, mid, key);
            else
                return searchBinary(ar, mid + 1, high, key);
        }
        return -1;
    }
}
