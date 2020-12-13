public class _94_BalanceParenthesis {

    public static void main(String[] args) {
        int n = 3;
        balanceParenthesis( 3, 3, "");
    }

    static void balanceParenthesis(int open, int close, String output) {
        if (open == 0 && close == 0) {
            System.out.println(output);
            return;
        }

        if (open < close) { // there is a scope to close. eg ((). here (remaining) open = 1 and close = 2
            if(open > 0) balanceParenthesis(open-1, close, output + "(");
            if(close > 0)balanceParenthesis(open, close-1, output + ")");
        } else {  // no scope for closing. eg (). here (remaining) open = 2 and close = 2
            if(open > 0) balanceParenthesis(open-1, close, output + "(");
        }
    }
}
