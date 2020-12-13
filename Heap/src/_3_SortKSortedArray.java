import java.util.PriorityQueue;


// k sorted means, the ith element can lie in the range [i-k and i+k] indexes (including)
public class _3_SortKSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 3, 2, 8, 10, 9};   // here 0th element should be 2 which lie on 0 + k = 3 index
        int k = 3;

        printArray(sortByHeap(arr, k));
    }

    private static int[] sortByHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // by default it is a min heap.. top will be minimum element

        int len = arr.length;
        int[] sortedArr = new int[len];
        int j = 0;
        for (int i = 0; i < len; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k)
                sortedArr[j++] = minHeap.poll();
        }

        while (!minHeap.isEmpty()) {
            sortedArr[j++] = minHeap.poll();
        }

        return sortedArr;
    }

    static void printArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
