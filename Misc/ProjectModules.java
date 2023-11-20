package Misc;

public class ProjectModules {
    // https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work/
    public long numberOfWeeks(int[] milestones) {
        int max = milestones[0];
        long sum = max;
        for (int i = 1; i < milestones.length; i++) {
            max = Math.max(max, milestones[i]);
            sum += milestones[i];
        }
        long x = sum - max;
        if (max - x > 1)
            return sum - (max - x - 1);
        return sum;
    }
}