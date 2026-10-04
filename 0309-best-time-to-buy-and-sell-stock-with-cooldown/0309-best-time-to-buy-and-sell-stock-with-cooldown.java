class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n <= 1) {
            return 0;
        }

        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            // Either keep holding or buy today after a rest
            hold = Math.max(prevHold, prevRest - prices[i]);

            // Sell the stock today
            sold = prevHold + prices[i];

            // Either continue resting or come from a cooldown
            rest = Math.max(prevRest, prevSold);
        }

        return Math.max(sold, rest);
    }
}