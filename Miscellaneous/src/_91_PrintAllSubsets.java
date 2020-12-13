import java.util.*;

public class _91_PrintAllSubsets {

    public static void main(String[] args) {
        String str = "abc";
        //subsets(str, "");

        String str1 = "aab";
        Set<String> set = new HashSet<>();
        Set<String> setOrdered = new LinkedHashSet<String>();
        Set<String> setSorted = new TreeSet<String>(); // lexically sorted
        uniqueSubsets(str1, "", set);
        printSet(set);
    }

    static void subsets(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        String op1 = output, op2 = output;   // one for inclusion and other for exclusion
        op1 += String.valueOf(input.charAt(0));
        input = input.substring(1);
        subsets(input, op1);
        subsets(input, op2);
    }

    static void uniqueSubsets(String input, String output, Set<String> set) {
        if (input.length() == 0) {
            set.add(output);
            return;
        }

        String op1 = output, op2 = output;   // one for inclusion and other for exclusion
        op1 += String.valueOf(input.charAt(0));
        input = input.substring(1);
        uniqueSubsets(input, op1, set);
        uniqueSubsets(input, op2, set);
    }

    static void printSet(Set<String> set) {
        for (String s : set)
            System.out.println(s);
    }
}
