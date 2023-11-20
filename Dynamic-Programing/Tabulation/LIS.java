import java.util.Arrays;

public class LIS {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[]) {
        int[] lis = new int[size]; // longest increasing subsequence ending at index i
        Arrays.fill(lis, 1);
        int max = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    lis[i] = Math.max(lis[j] + 1, lis[i]);
                }
            }
            max = Math.max(lis[i], max);
        }
        return max;
    }
}
