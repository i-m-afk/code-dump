public class FrogJump {
    private static int solve(int[] heights, int curr_position) {
        // base case
        if (curr_position <= 0)
            return 0;
        // jump 1 step backwards
        int left = Math.abs(heights[curr_position] - heights[curr_position - 1]) + solve(heights, curr_position - 1);
        // jump 2 steps backwards
        int right = Integer.MAX_VALUE;
        if (curr_position > 1)
            right = Math.abs(heights[curr_position] - heights[curr_position - 2]) + solve(heights, curr_position - 2);
        return Math.min(left, right);
    }

    public static int frogJump(int n, int heights[]) {
        return solve(heights, n - 1);
    }
}
