import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// given an array of stocks for n days
// find # of consecutive stocks smaller or equal before present day (including that day)
public class _7_MaxAreaRectangleInBinaryMatrix {

    public static void main(String[] args) {
        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85}; // ans = {1, 1, 1, 2, 1, 4, 6}
        int[] res = nearestGreaterToLeftIndex(arr);

        printArray(res);
    }

    private static int[] nearestGreaterToLeftIndex(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        Stack<List<Integer>> stack = new Stack<>();  // store index and data

        for (int i = 0 ; i < n; i++) {

            while (!stack.isEmpty() && stack.peek().get(1) <= arr[i])
                stack.pop();

            if (stack.isEmpty()) res[i] = 1;
            else res[i] = i - stack.peek().get(0);  // count = i - index(nearest Larger to left)
            List<Integer> ll = new ArrayList<>();
            ll.add(i);
            ll.add(arr[i]);
            stack.push(ll);
        }
        return res;
    }

    private static void printArray(int[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
