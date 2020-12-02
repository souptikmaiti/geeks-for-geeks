public class _8_FindMaximumIndexedSumInAllPossibleRotation {

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
        int[] ar1 = new int[]{1, 20, 2, 10};
        int[] ar2 = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        printArray(ar1);
        System.out.println(findMaxOfIndexedSumInAllRotation(ar1));
        printArray(ar2);
        System.out.println(findMaxOfIndexedSumInAllRotation(ar2));
    }

    static int findMaxOfIndexedSumInAllRotation(int[] ar) {
        int len = ar.length, max;
        int indexedSum = 0, total = 0;
        for (int i = 0; i < len; i ++) {
            indexedSum += ar[i] * i;
            total += ar[i];
        }

        max = indexedSum;

        // for rightward rotation
        /*for (int i = 1; i < len; i++) {
            indexedSum = indexedSum + total - len * ar[len - i];
            if (indexedSum > max)
                max = indexedSum;
        }*/

        // for leftward rotation
        for (int i = 1; i < len; i++) {
            indexedSum = indexedSum + len * ar[i - 1] - total;
            if (indexedSum > max)
                max = indexedSum;
        }
        return max;
    }
}
