public class _6_SearchPairWithGivenSumInRotatedArray {

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
        int[] ar1 = new int[]{11, 15, 6, 8, 9, 10};
        int[] ar2 = new int[]{30, 40, 50, 10, 20};
        printArray(ar1);
        printArray(searchPairInRotatedArray(ar1, 24));

        printArray(ar2);
        printArray(searchPairInRotatedArray(ar2, 50));
        printArray(searchPairInRotatedArray(ar2, 10));
        printArray(searchPairInRotatedArray(ar2, 30));
        printArray(searchPairInRotatedArray(ar2, 90));

    }

    static int[] searchPairInRotatedArray(int[] ar, int key) {
        int[] res = new int[2];
        int len = ar.length, max = findPivotIndex(ar), min = (max + 1) % len;
        while (min != max) {
            if (ar[min] + ar[max] > key) {
                max = (max + len -1) % len;  // similar to max-- but avoids -ve index by modulus
            }
            if (ar[min] + ar[max] < key) {
                min = (min + 1) % len; // avoids out of bound index
            }
            if (ar[min] + ar[max] == key) {
                res[0] = ar[min];
                res[1] = ar[max];
                return res;
            }
        }
        return null;
    }

    static int findPivotIndex(int[] ar) {
        int len = ar.length;
        int i;
        for (i = 0; i < len - 1; i++) {
            if (ar[i] > ar[i+1])
                return i;
        }
        return i + 1;
    }
}
