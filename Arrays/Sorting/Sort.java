package Arrays.Sorting;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        // Input array to be sorted
        int[] arr = { 25, 15, 35, 5, 45, 1 };

        // Call bucket sort on the input array
        BucketSort.bucketSort(arr, 10);

        // Print the sorted array
        for (int i : arr)
            System.out.print(i + " ");
    }

}
