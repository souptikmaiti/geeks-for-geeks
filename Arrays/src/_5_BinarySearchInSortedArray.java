public class _5_BinarySearchInSortedArray {

    static void printArray(int[] ar) {
        for (int j : ar)
            System.out.print(j + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] ar1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] ar2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        printArray(ar1);
        System.out.println(searchBinary(ar1, 0, ar1.length - 1, 3));

        printArray(ar2);
        System.out.println(searchBinary(ar2, 0, ar2.length - 1, 6));

    }

    static int searchBinary(int[] ar, int i, int j, int key) {
        if (i > j)
            return -1;
        if (i == j) {
            if (ar[i] == key)
                return i;
            return -1;
        }

        int len = j - i + 1, l;
        if (len % 2 == 0)
            l = len/2 - 1 + i;
        else
            l = len/2 + i;
        if (key == ar[l])
            return l;
        if (key < ar[l])
            return searchBinary(ar, i, l, key);
        if (key > ar[l])
            return searchBinary(ar, l + 1, j, key);

        return -1;
    }
}
