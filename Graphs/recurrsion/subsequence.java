package recurrsion;

import java.util.*;

public class subsequence {
    // static ArrayList<Integer> res = new ArrayList<>();

    static void getSubsequence(int[] arr, int idx, int n, ArrayList<Integer> res) {
        if (idx == n) {
            System.out.println(res + " ");
            // for (int i : res) {
            // System.out.println(i + " ");
            // }
            if (res.isEmpty()) {
                System.out.print("{}");
            }
            return;
        }
        // System.out.print("index:" + idx + "\n");
        res.add(arr[idx]);
        // pick
        getSubsequence(arr, idx + 1, n, res);
        // not pick
        res.remove(res.size() - 1);
        getSubsequence(arr, idx + 1, n, res);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 1 };
        int n = arr.length;
        ArrayList<Integer> ds = new ArrayList<>();
        getSubsequence(arr, 0, n, ds);
    }
}
