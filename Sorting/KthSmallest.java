package Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

// find kth the smallest element in an array
public class KthSmallest {

    // Naive , O(NlogN) time complexity
    private int sortNums(int[] nums, int k) {
        if (nums.length - 1 < k || k < 0)
            return -1;
        Arrays.sort(nums);
        return nums[k - 1];
    }

    // Using min heap and remove the kth element after insertion of all the elements
    // O(N) space and O(N) time complexity
    private int minHeap(int[] nums, int k) {
        if (nums.length - 1 < k || k < 0)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);
        }
        int res = -1;
        while (k-- > 0) {
            res = pq.remove();
        }
        return res;
    }

    // return index of the kth smallest element
    // Quick Select Algorithm
    // O(N^2) worst
    // O(N) average, O(1) space for once, but if not want to change the array then copies should be made
    // therefore O(N) space.
    private int kthSmallest(int[] arr, int n, int k) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int p = lomutoPartition(arr, l, r);
            if (p == k - 1)
                return p;
            else if (p > k - 1)
                return p - 1;
            else
                return l = p + 1;
        }
        return -1;
    }
    public  static int lomutoPartition(int[] nums, int low, int high) {
       int pivot = nums[high]; // last element pivot
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, high, i + 1);
        return (i + 1);
    }

    private static void swap(int[] nums, int high, int i) {
        int temp = nums[high];
        nums[high] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 30, 12};
        KthSmallest obj = new KthSmallest();
        System.out.println(arr[obj.kthSmallest(arr, arr.length-1, 2)]);
        System.out.println(obj.minHeap(arr, 2));
    }
}
