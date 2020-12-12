import java.util.ArrayList;

public class RecursionSort {

    static void print(ArrayList<Integer> arr) {
        int len = arr.size();
        for (int i = 0; i < len; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5); arr.add(8); arr.add(1); arr.add(3); arr.add(7); arr.add(6);
                //= new int[]{5, 8, 1, 3, 7, 6};
        print(arr);
        sortRecur(arr);
        print(arr);
    }

    private static void sortRecur(ArrayList<Integer> arr) {
        if (arr.size() == 1) return;

        int val = arr.remove(arr.size() - 1);
        sortRecur(arr);
        insertRecur(arr, val);
    }

    private static void insertRecur(ArrayList<Integer> arr, int val) {
        if (arr.size() == 0 || arr.get(arr.size() - 1) <= val) {
            arr.add(val);
            return;
        }

        int tmp = arr.remove(arr.size() - 1);
        insertRecur(arr, val);
        arr.add(tmp);
    }
}
