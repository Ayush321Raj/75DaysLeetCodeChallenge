class Solution {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {

            for (int curr = coin; curr <= amount; curr++) {

                dp[curr] += dp[curr - coin];
            }
        }

        return dp[amount];
    }
}