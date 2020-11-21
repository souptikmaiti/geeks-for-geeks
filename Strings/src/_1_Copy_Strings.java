public class _1_Copy_Strings {

    public static void main(String[] args) {
        char[] s1 = "Hello Strings".toCharArray();
        char[] s2 = new char[s1.length];
        copyRecursive(s1, s2, 0, s1.length);
        System.out.println(s2);
    }

    static void copyIterative(char[] s1, char[] s2) {
        for (int i = 0; i < s1.length; i++) {
            s2[i] = s1[i];
        }
    }

    static void copyRecursive(char[] s1, char[] s2, int index, int len) {
        if (index <0 || index >len-1)
            return;
        s2[index] = s1[index];
        index ++;
        copyRecursive(s1, s2, index, len);
    }
}
