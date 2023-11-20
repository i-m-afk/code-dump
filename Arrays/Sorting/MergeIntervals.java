package Arrays.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/merge-intervals/description/
public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sorted by low interval
            int low = intervals[0][0], high = intervals[0][1];
            ArrayList<int[]> list = new ArrayList<int[]>();
            for (int i = 1; i < intervals.length; i++) {
                int newHigh = intervals[i][1];
                int newLow = intervals[i][0];
                // no overlap
                if (high < newLow) {
                    list.add(new int[] { low, high });
                    low = newLow;
                    high = newHigh;
                }
                // some overlap or / everything overlaped or edge overlap
                if (high >= newLow && high < newHigh) {
                    high = newHigh;
                }
            }
            int n = list.size();
            if (n != 0) {
                if (list.get(n - 1)[1] != high) {
                    list.add(new int[] { low, high });
                }
            } else {
                list.add(new int[] { low, high });
            }

            int[][] result = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }
}
