public class _93_PermutationWithCaseChange {

    public static void main(String[] args) {
        String str = "abc";
        permuteCase( str, "");

        String str1 = "a1B2c3";
        permuteCaseWithDigit(str1, "");
    }

    static void permuteCase(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        String op1 = output, op2 = output;   // one for inclusion and other for exclusion
        op1 += String.valueOf(input.charAt(0)).toLowerCase();
        op2 += String.valueOf(input.charAt(0)).toUpperCase();
        input = input.substring(1);
        permuteCase(input, op1);
        permuteCase(input, op2);
    }

    static void permuteCaseWithDigit(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        String op1 = output, op2 = output;   // one for inclusion and other for exclusion
        char c = input.charAt(0);
        if ((c >= 'a' && c<= 'z') || (c>='A' && c<='Z')) {
            op1 += String.valueOf(c).toLowerCase();
            op2 += String.valueOf(c).toUpperCase();
            input = input.substring(1);
            permuteCaseWithDigit(input, op1);
            permuteCaseWithDigit(input, op2);
        } else {
            op1 += c;
            input = input.substring(1);
            permuteCaseWithDigit(input, op1);
        }
    }
}
