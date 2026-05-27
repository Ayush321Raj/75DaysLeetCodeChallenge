class Solution {

    public int numDecodings(String s) {

        int n = s.length();

        int[] dp = new int[n + 1];

        // Base case
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {

            // Cannot decode '0'
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            // Take one digit
            dp[i] = dp[i + 1];

            // Take two digits
            if (i < n - 1) {

                int num =
                    (s.charAt(i) - '0') * 10
                    + (s.charAt(i + 1) - '0');

                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}