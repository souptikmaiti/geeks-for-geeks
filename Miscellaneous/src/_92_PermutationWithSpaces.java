import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class _92_PermutationWithSpaces {

    public static void main(String[] args) {
        String str = "ABC";

        permuteSpaces( str.substring(1), str.substring(0,1));
    }

    static void permuteSpaces(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        String op1 = output, op2 = output;   // one for inclusion and other for exclusion
        op1 += "_" + input.charAt(0);
        op2 += input.charAt(0);
        input = input.substring(1);
        permuteSpaces(input, op1);
        permuteSpaces(input, op2);
    }
}
