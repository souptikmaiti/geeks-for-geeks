import java.math.BigInteger;
import java.util.ArrayList;

public class NthCatalanNumber {

    public static void main(String[] args) {
        //System.out.println(findCatalanRecursion(5));
        System.out.println(findCatalanDynamic(20));
    }

    public static BigInteger findCatalanRecursion(int n) {
        if (n <= 1)
            return BigInteger.valueOf(1);

        BigInteger res = BigInteger.valueOf(0);

        for (int i =0; i<= n-1; i++)
            res = res.add(findCatalanRecursion(i).multiply(findCatalanRecursion(n - 1 -i)));

        return res;
    }


    //1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862 ....
    public static BigInteger findCatalanDynamic(int n) {
        BigInteger[] catalans = new BigInteger[n + 1];
        catalans[0] = BigInteger.valueOf(1);
        catalans[1] = BigInteger.valueOf(1);

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
