// Problem Statement: make all possible tree for the given string

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _27_ScrambledString {
    static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        String str1 = "great";
        //String str2 = "reatg";
        //String str2 = "rgatg";
        String str2 = "gatre";

        System.out.println(isScrambled(str1, str2));
    }

    static boolean isScrambled(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        if (str1.length() != str2.length())
            return false;
        if (str1.equals(str2))
            return true;
        if (str1.length() == 1 && !str1.equals(str2))
            return false;

        String key = str1 + "_" + str2;
        if (map.containsKey(key)) return map.get(key);

        boolean result = false;
        int n = str1.length();

        // ref: substring(included, excluded) i.e, substring(i, j) will give i to j-1 both included
        for (int k = 1; k < n; k++) {
            boolean swapped = isScrambled(str1.substring(0, k), str2.substring(n-k, n))
                    && isScrambled(str1.substring(k, n), str2.substring(0, n-k));

            boolean notSwapped = isScrambled(str1.substring(0, k), str2.substring(0, k))
                    && isScrambled(str1.substring(k, n), str2.substring(k, n));

            if (swapped || notSwapped) {
                result = true;
                break;
            }
        }
        map.put(key, result);
        return result;
    }
}
