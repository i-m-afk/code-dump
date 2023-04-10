/*
 * array [1, 3, 1, 2, 4,1, 2] and want to get number of diffrent subarrays whoes
 * max and min element difference is less than 2
 */
public class MaxMinSubarrayCount {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 1, 2, 4, 1, 2 };
        int S = 2;
        int count = 0;
        int min = arr[0];
        int max = arr[0];
        for (int i = 0, j = 1; j < arr.length; j++) {
            min = Math.min(min, arr[j]);
            max = Math.max(max, arr[j]);
            int diff = max - min;
            if (diff > S) {
                i = j;
                count++;
                max = arr[j];
                min = arr[j];
            }
        }
        System.out.print(count + 1);
    }

}