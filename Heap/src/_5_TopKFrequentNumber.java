import java.util.*;

public class _5_TopKFrequentNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 3, 2, 2, 4};
        int k = 2;

        frequentNumbers(arr, k);
    }

    private static void frequentNumbers(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            map.put(arr[i], map.containsKey(arr[i])? map.get(arr[i]) + 1: 1);
        }

        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> n1, List<Integer> n2) {
                if (n1.get(0) > n2.get(0)) return +1;  // if second element is smaller return true/+1
                if (n1.get(0) < n2.get(0)) return -1;
                else return 0;
            }
        });

        for (Integer key : map.keySet()) {
            List<Integer> ll = new ArrayList<>();
            ll.add(map.get(key));
            ll.add(key);
            minHeap.add(ll);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        while (!minHeap.isEmpty()) {
            List<Integer> ll = minHeap.poll();
            System.out.print("Frequency: " + ll.get(0) + ", " + "Number: " + ll.get(1) + "\n");
        }
    }
}
