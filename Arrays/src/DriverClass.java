import java.io.InputStream;
import java.util.Scanner;

public class DriverClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noArrays = scanner.nextInt();

        for (int i = 0; i < noArrays; i++) {
            int len = scanner.nextInt();
            int[] ar = new int[len];
            for (int j = 0; j< len; j++)
                ar[j] = scanner.nextInt();

            printArray(ar);
        }
    }

    static void printArray(int[] ar) {
        if (ar == null) {
            System.out.println("Not Found");
            return;
        }
        for (int j : ar)
            System.out.print(j + " ");
        System.out.println("");
    }
}
