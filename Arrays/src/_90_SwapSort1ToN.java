// a array of size n contains element from 1 to n
// one element is missing and in place of that other element is duplicated
// find the missing and duplicate element
public class _90_SwapSort1ToN {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3 , 1, 5, 1}; // here 4 is missing and 1 is duplicate
        printArray(arr);
        swapSort(arr);
        printArray(arr);
        printMissingAndDuplicate(arr);
    }

    private static void swapSort(int[] arr) {
        int n = arr.length;
        // in ideal sorted 1 to n array arr[i] = i + 1

        int i = 0;
        while (i < n) {
            if (arr[i] == i + 1){
                i++;
            } else {
                int properPlace = arr[i]-1;
                int tmp = arr[properPlace];
                if (tmp == arr[i]) {  // duplicate
                    i++;
                } else {
                    arr[properPlace] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    private static void printMissingAndDuplicate(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] != i+1)
                System.out.println("Missing: " + String.valueOf(i+1) + ", Duplicate: " + arr[i]);
        }
    }

    static void printArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
