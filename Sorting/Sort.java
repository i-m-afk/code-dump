package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class MyCmp implements Comparator<Integer> {
    public int compare(Integer x, Integer y) {
        return x % 2 - y % 2;
    }
}

public class Sort {
    // Time: O(n^2)
    // inplace and stable sorting algorithm
    public static void bubbleSort(int[] arr, int n) {
        while (n-- > 0) {
            int i = 0, j = 1;
            while (j < arr.length) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void optimisedBubbleSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    // best for small size arrays
    // Best: O(n) (already sorted)
    // worst: O(n^2) (reverse sorted)
    // avg: theta(n^2)
    public static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                int idx = find(arr, arr[i], i);
                copy(arr, idx, i, arr[i]);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // linear search
    private static int find(int[] arr, int x, int end) {
        int res = end;
        for (int i = 0; i < end; i++) {
            if (arr[i] >= x) {
                res = i;
                break;
            }
        }
        return res;
    }

    private static void copy(int[] arr, int start, int end, int x) {
        for (int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = x;
    }

    // another approach
    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }

    /*
     * Merge sort
     * Divide and conquer algo
     * stable algo
     * theta(nlogn)
     * O(n)
     * good for Linked list and takes O(1) aux space
     * External Sorting
     * In genral Quicksort diffs
     */
    // Merge sorted Arrays
    static void mergeSortedArrays(int[] a, int[] b, int m, int n) {
        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            // equal to to maintain stablity
            if (a[i] <= b[j]) {
                res[k] = a[i++];
            } else {
                res[k] = b[j++];
            }
            k++;
        }
        while (i < m) {
            res[k++] = a[i++];
        }
        while (j < n) {
            res[k++] = b[j++];
        }
        System.out.println(Arrays.toString(res));
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int m = mid - low + 1;
        int n = high - mid;
        int[] left = new int[m];
        int[] right = new int[n];
        for (int i = 0; i < m; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n; i++) {
            right[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0, k = low;
        while (i < m && j < n) {
            // equal to to maintain stablity
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < n) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid); // sort left half
            mergeSort(arr, mid + 1, r); // sort right half
            merge(arr, l, mid, r); // merge those halfs
        }
    }

    public static ArrayList<Integer> findUnion(int a[], int b[], int m, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int lastadded = -1;
        while (i < m && j < n) {
            if (a[i] < b[j]) {
                if (lastadded != a[i]) {
                    list.add(a[i]);
                    lastadded = a[i];
                }
                i++;
            } else if (a[i] > b[j]) {
                if (lastadded != b[j]) {
                    list.add(b[j]);
                    lastadded = b[j];
                }
                j++;
            } else {
                if (lastadded != a[i]) {
                    list.add(a[i]);
                    lastadded = a[i];
                }
                i++;
                j++;
            }
        }
        while (i < m) {
            if (lastadded != a[i]) {
                list.add(a[i]);
                lastadded = a[i];
            }
            i++;
        }
        while (j < n) {
            if (lastadded != b[j]) {
                list.add(b[j]);
                lastadded = b[j];
            }
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2, 7, 1, 10 };
        // bubbleSort(arr, arr.length);
        // insertionSort(arr);
        // merge(arr, 0, 3, 6);
        // mergeSort(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));
        // int[] a = { 3, 5, 8 };
        // int[] b = { 2, 8, 9, 10, 15 };
        // System.out.println(findUnion(a, b, a.length, b.length));
        // QuickSort.partition(arr, 0, arr.length - 1, 2);
        System.out.println(QuickSort.hoarePartition(arr, 0, arr.length - 1));
    }

    public void sortEvenOdd(Integer[] arr) {
        Arrays.sort(arr, new MyCmp());
        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    static long countInversion;

    static void merge(long arr[], long low, long mid, long high) {
        // Create copies of the array left and right
        int m = (int) (mid - low + 1);
        int n = (int) (high - mid);
        long[] left = new long[m];
        long[] right = new long[n];
        for (int i = 0; i < m; i++) {
            left[i] = arr[(int) low + i];
        }
        for (int i = 0; i < n; i++) {
            right[i] = arr[(int) (mid + i + 1)];
        }

        // Merge (here we count inversions)
        int i = 0, j = 0, k = (int) low;
        while (i < m && j < n) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                countInversion += m - i; // Count inversions
            }
        }

        // Copy remaining elements of left and right subarrays
        while (i < m) {
            arr[k++] = left[i++];
        }
        while (j < n) {
            arr[k++] = right[j++];
        }
    }

    static void mergeSort(long arr[], long low, long high) {
        if (low < high) {
            long mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static long inversionCount(long arr[], long N) {
        countInversion = 0;
        mergeSort(arr, 0, N - 1);
        return countInversion;
    }
}