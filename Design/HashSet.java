package Design;

import java.util.Arrays;

//https://leetcode.com/problems/design-hashset/
// not optimized, simple soln
public class HashSet {
    private int[] arr;

    public HashSet() {
        arr = new int[1000001];
        Arrays.fill(arr, -1);
    }

    public void add(int key) {
        if (arr[key] == -1)
            arr[key] = key;
    }

    public void remove(int key) {
        if (arr[key] != -1)
            arr[key] = -1;
    }

    public boolean contains(int key) {
        return arr[key] != -1;
    }
}
