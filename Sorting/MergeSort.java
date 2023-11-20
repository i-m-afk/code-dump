package Sorting;

import java.util.Arrays;

public class MergeSort {
    private int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int n = left.length;
        int m = right.length;
        int[] res = new int[n + m];
        int k = 0;
        while (i < n && j < m) {
            // ascending order sorted
            if (left[i] < right[j]) {
                res[k++] = left[i++];
            } else {
                res[k++] = right[j++];
            }
        }
        while (i < n) {
            res[k++] = left[i++];
        }
        while (j < m) {
            res[k++] = right[j++];
        }
        return res;
    }

    private int[] partition(int[] nums, int i, int j) {
        if (i >= j) {
            int[] res = new int[1];
            res[0] = nums[i];
            return res;
        }
        int mid = (i + j) / 2;
        int[] left = partition(nums, i, mid);
        int[] right = partition(nums, mid + 1, j);
        return merge(left, right);
    }

    

    public static void main(String[] args) {
        int[] a = { 10, 15, 20, 20 };
        int[] b = { 1, 12 };

        // MergeSort sorter = new MergeSort();
        // int[] sortedArray = sorter.partition(nums, 0, nums.length - 1);
    }
}
