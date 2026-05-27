class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        // Edge case
        if (n == 1) {
            return nums[0];
        }

        // Case 1: Exclude last house
        int case1 = robRange(nums, 0, n - 2);

        // Case 2: Exclude first house
        int case2 = robRange(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robRange(int[] nums, int start, int end) {

        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {

            int pick = nums[i] + prev2;

            int notPick = prev1;

            int current = Math.max(pick, notPick);

            prev2 = prev1;

            prev1 = current;
        }

        return prev1;
    }
}