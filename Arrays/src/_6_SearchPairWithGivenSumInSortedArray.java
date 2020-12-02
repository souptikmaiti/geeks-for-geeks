public class _6_SearchPairWithGivenSumInSortedArray {

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
        int[] ar1 = new int[]{6, 8, 9, 10, 11, 15};
        int[] ar2 = new int[]{9, 10, 11, 15, 26, 38};
        printArray(ar1);
        printArray(searchPairInSortedArray(ar1, 16));
        printArray(searchPairInSortedArray(ar1, 20));

        printArray(ar2);
        printArray(searchPairInSortedArray(ar2, 35));
        printArray(searchPairInSortedArray(ar2, 45));

    }

    static int[] searchPairInSortedArray(int[] ar, int key) {
        int[] res = new int[2];
        int i = 0, j = ar.length - 1;
        while (i < j) {
            if (ar[i] + ar[j] > key)
                j --;
            if (ar[i] + ar[j] < key)
                i ++;
            if (ar[i] + ar[j] == key) {
                res[0] = ar[i];
                res[1] = ar[j];
                return res;
            }
        }
        return null;
    }
}
