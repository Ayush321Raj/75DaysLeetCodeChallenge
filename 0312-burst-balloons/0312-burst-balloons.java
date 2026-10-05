class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Add virtual balloons with value 1 at both ends
        int[] balloons = new int[n + 2];

        balloons[0] = 1;
        balloons[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        // dp[left][right] = maximum coins
        // from bursting balloons between left and right
        int[][] dp = new int[n + 2][n + 2];

        // Length of the interval
        for (int length = 2; length <= n + 1; length++) {

            for (int left = 0; left + length <= n + 1; left++) {

                int right = left + length;

                // Try every balloon as the LAST balloon to burst
                for (int k = left + 1; k < right; k++) {

                    int coins = dp[left][k]
                              + dp[k][right]
                              + balloons[left] * balloons[k] * balloons[right];

                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[0][n + 1];
    }
}