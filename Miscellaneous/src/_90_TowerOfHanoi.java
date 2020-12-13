// 3 poles (source, destination and helper) and n plates with ascending radius are given
// source pole has n plates. The radii of plates are increasing from top to bottom
// Print steps required to shift all the n plates from source to destination with help of helper
// Condition: 1. Shift 1 plate at a time
// Condition: 2. The destination pole also contain the n plates such a manner that radii of plates increases from top to bottom
public class _90_TowerOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        char s = 's', d = 'd', h = 'h';
        Wrapper count = new Wrapper(0);
        toh(n, s, d, h, count);
        System.out.println("Steps: " + count.i);
    }

    static void toh(int n, char s, char d, char h, Wrapper count) {

        count.i ++;
        if (n == 1) {
            System.out.println("Move " + n + " from " + s + " to " + d);
            return;
        }

        toh(n-1, s, h, d, count);  //transfer n-1 to helper with help of destination
        System.out.println("Move " + n + " from " + s + " to " + d); //move the last remaining disk from source to destination
        toh(n-1, h, d, s, count);  //transfer n-1 disks from helper to destination with help of source
    }

    static class Wrapper {
        // passing Integer to a function will not modify though it points to a Integer object, becoz Integer is immutable class
        // so we need to wrap an int inside a class to pass it as reference

        int i;
        Wrapper(int i) {
            this.i = i;
        }
    }
}
