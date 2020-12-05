import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class _1_NthCatalanNumber {
    static BigInteger[] t;
    public static void main(String[] args) {
        //1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862 ....

        //System.out.println(findCatalanRecursion(5));
        int n = 20;
        t = new BigInteger[n + 2];
        Arrays.fill(t, BigInteger.valueOf(-1));
        System.out.println(findCatalanMemoize(20));
        //System.out.println(findCatalanRecursion(20));
        System.out.println(findCatalanDynamic(20));
    }

    public static BigInteger findCatalanMemoize(int n) {
        if (n == 0 || n == 1)
            return BigInteger.valueOf(1);

        if (!t[n].equals(BigInteger.valueOf(-1)))
            return t[n];

        BigInteger res = BigInteger.valueOf(0);

        for (int i =0; i<= n-1; i++)
            res = res.add(findCatalanMemoize(i).multiply(findCatalanMemoize(n - 1 -i)));
        return t[n] = res;
    }


    public static BigInteger findCatalanRecursion(int n) {
        if (n == 0 || n == 1)
            return BigInteger.valueOf(1);

        BigInteger res = BigInteger.valueOf(0);

        for (int i =0; i<= n-1; i++)
            res = res.add(findCatalanRecursion(i).multiply(findCatalanRecursion(n - 1 -i)));

        return res;
    }

    public static BigInteger findCatalanDynamic(int n) {
        BigInteger[] catalans = new BigInteger[n + 2];
        catalans[0] = BigInteger.valueOf(1); // corresponds to base condition of recursion
        catalans[1] = BigInteger.valueOf(1); // corresponds to base condition of recursion

        for (int i = 2; i <= n ; i ++) {
            BigInteger s = BigInteger.valueOf(0);
            for (int j = 0; j < i; j ++) {
                s = s.add(catalans[j].multiply(catalans[i - 1 - j]));
            }
            catalans[i] = s;
        }
        return catalans[n];
    }
}
