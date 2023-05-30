package Arrays.Sorting;

import java.util.*;

public class BucketSort {
    public static void bucketSort(int[] arr, int numBuckets) {
        // Determine the range of values in the input array
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        // Divide the range of values into buckets
        double bucketRange = (double) (maxValue - minValue + 1) / numBuckets;
        List<Integer>[] buckets = new List[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            int bucketIdx = (int) ((arr[i] - minVal) / ((maxVal - minVal) / numBuckets));
            buckets[bucketIdx].add(arr[i]);
        }

        // Sort each bucket using insertion sort
        for (int i = 0; i < numBuckets; i++) {
            Deque<Integer> deque = new ArrayDeque<>(buckets[i]);
            for (int j = 1; j < deque.size(); j++) {
                int key = deque.removeFirst();
                int k = j - 1;
                while (k >= 0 && deque.peekFirst() < key) {
                    deque.addFirst(deque.removeLast());
                    k--;
                }
                deque.addFirst(key);
            }
            buckets[i] = new ArrayList<>(deque);
        }

        // Concatenate the sorted buckets
        int k = 0;
        for (int i = 0; i < numBuckets; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[k++] = buckets[i].get(j);
            }
        }
    }
}
