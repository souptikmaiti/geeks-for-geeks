import java.util.HashSet;
import java.util.Set;

public class _2_Alphabet_Checking {

    public static void main(String[] args) {
        String str1 = "The Quick Brown Fox Jumps Over the Lazy Dog";
        String str2 = "The quick brown fox jumps over the dog";

        System.out.println(checkPangram(str1));
        System.out.println(checkPangram(str2));
    }

    static boolean checkPangram(String str) {
        int len = str.length();
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i<len; i++) {
            char ch = str.charAt(i);
            if (ch >= 97 && ch <= 122)
                characterSet.add(ch);
            if (ch >= 65 && ch <= 90)
                characterSet.add((char)(ch + 32));
        }
        return characterSet.size() == 26;
    }
}
