import java.util.Stack;

// given an array of stocks for n days
// find # of consecutive stocks smaller or equal before present day (including that day)
public class _8_RainDroppingProplem {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 0, 2, 0, 4}; // ans = sum( Min( Max(lef array), Max(right array)) - arr[i]), i = 1...n-1
        System.out.println(raindropAccumulate(arr));
    }

    private static int raindropAccumulate(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty()) {
                leftMax[i] = stack.peek();
                if (stack.peek() < arr[i]) {
                    stack.pop();
                    stack.push(arr[i]);
                }
            } else {
                leftMax[i] = -1;
                stack.push(arr[i]);
            }
        }

        for (int i = n-1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                rightMax[i] = stack.peek();
                if (stack.peek() < arr[i]) {
                    stack.pop();
                    stack.push(arr[i]);
                }
            } else {
                rightMax[i] = -1;
                stack.push(arr[i]);
            }
        }

        int sum =0;
        for (int i = 1; i <= n-2 ; i++) {
            int height = Math.min(leftMax[i], rightMax[i]);
            sum += (height - arr[i]);
        }

        return sum;
    }
}
