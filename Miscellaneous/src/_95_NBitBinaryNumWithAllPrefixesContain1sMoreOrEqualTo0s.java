// N = 11010
// its all prefixes are
// 11010, 1101, 110, 11, 1
// and all the prefixes has #1's >= #0's

public class _95_NBitBinaryNumWithAllPrefixesContain1sMoreOrEqualTo0s {

    public static void main(String[] args) {
        int n = 4;
        findPrefixes( 0, 0, "", n);
    }

    static void findPrefixes(int ones, int zeros, String output, int n) {
        if (ones + zeros == n) {
            System.out.println(output);
            return;
        }

        if (zeros < ones) {
            findPrefixes(ones, zeros + 1, output + "0", n);
            findPrefixes(ones + 1, zeros, output + "1", n);
        } else {
            findPrefixes(ones + 1, zeros, output + "1", n);
        }
    }
}
