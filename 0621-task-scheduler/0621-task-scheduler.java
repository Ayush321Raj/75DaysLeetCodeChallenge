class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequencies
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find max frequency
        int maxFreq = 0;

        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Count tasks with max frequency
        int maxCount = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        int result =
                (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(result, tasks.length);
    }
}