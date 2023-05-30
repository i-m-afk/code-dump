package Arrays.Sorting;

import java.util.*;

public class RadixSort {
    public static void radixSort(int[] arr) {
        // Determine the maximum number of digits
        int maxDigits = 0;
        for (int i = 0; i < arr.length; i++) {
            maxDigits = Math.max(maxDigits, (int) Math.log10(arr[i]) + 1);
        }

        // Sort the digits from least significant to most significant
        Deque<Integer>[] queues = new Deque[10];
        for (int i = 0; i < 10; i++) {
            queues[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < maxDigits; i++) {
            for (int j = 0; j < arr.length; j++) {
                int digit = (arr[j] / (int) Math.pow(10, i)) % 10;
                queues[digit].offer(arr[j]);
            }
            int k = 0;
            for (int j = 0; j < 10; j++) {
                while (!queues[j].isEmpty()) {
                    arr[k++] = queues[j].poll();
                }
            }
        }
    }
}
