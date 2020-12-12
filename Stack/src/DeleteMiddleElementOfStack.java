import java.util.Stack;

public class DeleteMiddleElementOfStack {

    static void printStackBottomUp(Stack<Integer> stack) {
        if (stack.empty()) return;
        int tmp = stack.pop();
        printStackBottomUp(stack);
        System.out.print(tmp + " ");

        stack.push(tmp); // again retaining the elements of the stack
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        printStackBottomUp(stack);
        System.out.println();
        deleteMid(stack, stack.size()/2);
        printStackBottomUp(stack);
    }

    static void deleteMid(Stack<Integer> stack, int mid) {
        if (mid == 0) {
            stack.pop();
            return;
        }

        int tmp = stack.pop();
        deleteMid(stack, mid - 1);
        stack.push(tmp);
    }
}
