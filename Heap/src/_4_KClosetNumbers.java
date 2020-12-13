import java.util.*;

public class _4_KClosetNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 8, 5, 7, 9};
        int k = 3;
        int key = 7;

        closestKth(arr, k, key);
    }

    private static void closestKth(int[] arr, int k, int key) {
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> n1, List<Integer> n2) {
                if (n2.get(0) > n1.get(0)) return +1;    // if second element is greater return true/+1
                else if (n2.get(0) < n1.get(0)) return -1;
                else return 0;
            }
        });

        int len = arr.length;
        for (int i = 0; i < len; i++) {
            List<Integer> ll = new ArrayList<Integer>();
            ll.add(Math.abs(arr[i] - key));
            ll.add(arr[i]);
            maxHeap.add(ll);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        while (!maxHeap.isEmpty()) {
            List<Integer> ll = maxHeap.poll();
            System.out.print("Difference: " + ll.get(0) + ", " + "Number: " + ll.get(1) + "\n");
        }
    }


}
