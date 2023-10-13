package Sorting;

import java.util.Arrays;

public  class QuickSort {

    // naive
    static void partition(int[] nums, int low, int high, int p) {
        // 4 , 1, 33, 0, 99, 6
        // --
        int[] temp = new int[nums.length];
        int index = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] <= nums[p]) {
                temp[index] = nums[i];
                index++;
            }
        }
        for (int i = low; i <= high; i++) {
            if (nums[i] > nums[p]) {
                temp[index] = nums[i];
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Lomuto Partition
    // if pivot is always a last element
    public  static int lomutoPartition(int[] nums, int low, int high) {
        // maintain window of smaller and greater element
        // | smaller elements ... || .. larger_element (>=) | pivot
        // after complete iteration swap nums[i+1] with nums[pivot]
        int pivot = nums[high]; // last element pivot
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, high, i + 1);
        // System.out.println(Arrays.toString(nums));
        return (i + 1);
    }

    // around any pivot in array: swap it with the last element
    static int lomutoPartition(int[] nums, int low, int high, int p) {
        swap(nums, p, high);
        int pivot = nums[high]; // last element pivot
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, high, i + 1);
        // System.out.println(Arrays.toString(nums));
        return (i + 1);
    }

    // Hoare's partition
    // in hoare's partition, partition correct position is not insured
    static int hoarePartition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            } while (nums[i] < pivot); // go right and stop if greater element than pivot is found
            do {
                j--;
            } while (nums[j] > pivot); // go left and vise versa
            if (i >= j) {
                // System.out.println(Arrays.toString(nums));
                return j; // crossed each other seperation happened
            }
            swap(nums, i, j);
        }

    }

    static void qSort(int[] nums, int low, int high) {
        if (low < high) {
            int p = hoarePartition(nums, low, high);
            qSort(nums, low, p);
            qSort(nums, p + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 8, 4, 7, 9, 3, 10, 5 };
        partition(nums, 0, nums.length-1, 2 );
        qSort(nums, 0, nums.length - 1);
        System.out.print(Arrays.toString(nums));
    }
}