import java.util.Stack;

public class ReverseStackWithoutExtraSpace {
    static void printStackTopDown(Stack<Integer> stack) {
        if (stack.empty()) return;
        int tmp = stack.pop();
        System.out.print(tmp + " ");
        printStackTopDown(stack);

        stack.push(tmp); // again retaining the elements of the stack
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        printStackTopDown(stack);
        System.out.println();
        reverseStack(stack);
        printStackTopDown(stack);
    }

    static void reverseStack(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return;
        }

        int tmp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, tmp);
    }

    private static void insertAtBottom(Stack<Integer> stack, int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        int tmp = stack.pop();
        insertAtBottom(stack, val);
        stack.push(tmp);
    }
}
