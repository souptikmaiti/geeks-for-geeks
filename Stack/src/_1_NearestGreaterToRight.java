import java.util.Stack;

public class _1_NearestGreaterToRight {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 0, 0, 1, 2, 4, 3};
        int n = arr.length;
        int[] res = nearestLarger(arr);

        /* brute force O(n^2)
        int[] res = new int[n];
        for (int i = 0; i < n ; i++) {
            res[i] = -1;
            for (int j = i + 1; j < n; j++) {  // j dependent on i therefore scope of stack
                if (arr[i] < arr[j]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }*/

        printArray(res);
    }

    private static int[] nearestLarger(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();

            if (stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();
            stack.push(arr[i]);
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
