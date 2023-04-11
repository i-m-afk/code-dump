package Arrays.KadanesAlgorithm;

/*
 * Problem statement: https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
 */
public class MaximumSumSubArray {
    // arr: input array
    // n: size of array
    // Function to find the sum of contiguous subarray with maximum sum.

    // Kadane's Algorithm:
    // maximum sum of subarray can be:
    // a) maximum of previous sum or current value
    // b) maximum of current value + previous sum or current value
    // c) maximum of both a) and b)
    long maxSubarraySum(int arr[], int n) {
        // Loop through the array starting from the second element
        for (int i = 1; i < n; i++) {
            // Choose the maximum value between the current element and the sum of the
            // previous element and the current element
            // Then, choose the maximum between the value obtained above and the current
            // element to handle negative numbers
            arr[i] = Math.max(Math.max(arr[i], arr[i - 1] + arr[i]), arr[i]);
        }
        // Initialize the maximum value with the first element of the array
        int max = arr[0];
        // Loop through the array starting from the second element
        for (int i = 1; i < n; i++) {
            // Choose the maximum between the current element and the maximum value so far
            max = Math.max(arr[i], max);
        }
        // Return the maximum sum
        return max;
    }
}
