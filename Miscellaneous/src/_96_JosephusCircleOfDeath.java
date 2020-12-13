// n people will stand in a circle, indexed like 1, 2, 3, 4...
// 1 will start counting and kth man will be shot dead
// the man after the dead body will start counting (excluding dead ones) and kth will be shot dead
// We have to find out the last man alive(the index)

import java.util.ArrayList;

public class _96_JosephusCircleOfDeath {

    public static void main(String[] args) {
        int n = 40;
        int k = 7;
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < n; i++)
            arr.add(i + 1);

        lastManAlive(arr, 0, k);
    }

    static void lastManAlive(ArrayList<Integer> arr, int start, int k) {
        if (arr.size() == 1) {
            System.out.println(arr.get(0));
            return;
        }

        int kill = (start + k - 1) % arr.size();
        arr.remove(kill);
        lastManAlive(arr, kill, k);
    }
}
