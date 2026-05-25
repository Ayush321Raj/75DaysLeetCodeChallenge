class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find maximum pile
        for (int pile : piles) {

            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            long hours = 0;

            // Calculate total hours needed
            for (int pile : piles) {

                hours += (pile + mid - 1) / mid;
            }

            // Can finish within h hours
            if (hours <= h) {

                right = mid;
            }

            // Too slow
            else {

                left = mid + 1;
            }
        }

        return left;
    }
}