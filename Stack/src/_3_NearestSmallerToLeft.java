import java.util.Stack;

public class _3_NearestSmallerToLeft {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 0, 0, 1, 2, 4, 1};
        int n = arr.length;
        int[] res = nearestSmallerToLeft(arr);

        printArray(res);
    }

    private static int[] nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i])
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
