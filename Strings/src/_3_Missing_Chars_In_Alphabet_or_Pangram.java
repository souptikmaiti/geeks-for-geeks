import java.util.HashSet;
import java.util.Set;

public class _3_Missing_Chars_In_Alphabet_or_Pangram {

    public static void main(String[] args) {
        String str1 = "The Quick Brown Fox Jumps Over the Lazy Dog";
        String str2 = "The quick brown fox jumps over the dog";

        System.out.println(missingChars(str1));
        System.out.println(missingChars(str2));
    }

    static String missingChars(String str) {
        int[] flags = new int[26];
        int len = str.length();
        for (int i = 0; i<len; i++) {
            char ch = str.charAt(i);
            if (ch >= 97 && ch <= 122)
                flags[ch - 97] = flags[ch - 97] + 1;
            if (ch >= 65 && ch <= 90)
                flags[(ch + 32) - 97] = flags[(ch + 32) - 97] +1;
        }
        String ss = "";
        for (int i =0; i<26; i++) {
            if (flags[i] == 0)
                ss += (char) (i +97) ;
        }
        return ss;
    }
}
