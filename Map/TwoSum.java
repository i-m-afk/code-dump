package Map;

import java.util.HashMap;

//  https://leetcode.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.get(n) != null) {
                return new int[] { map.get(n), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
