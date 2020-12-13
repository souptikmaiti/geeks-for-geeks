import java.util.*;

public class _6_ConnectRopesToMinimizeCost {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};

        minimizeCost(arr);
    }

    private static void minimizeCost(int[] arr) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        int cost = 0;
        while (minHeap.size() > 1) {
            int lowest = minHeap.poll();
            int secondLowest = minHeap.poll();
            cost += lowest + secondLowest;
            minHeap.add(lowest + secondLowest);
        }

        if (minHeap.size() == 1)
            System.out.println("Minimum Cost: " + cost);
    }
}
