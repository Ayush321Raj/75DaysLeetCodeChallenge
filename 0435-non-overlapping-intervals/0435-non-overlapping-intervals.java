class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort by ending time
        Arrays.sort(intervals,
                (a, b) -> a[1] - b[1]);

        int count = 0;

        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            // Overlap
            if (start < prevEnd) {

                count++;

            } else {

                // No overlap
                prevEnd = end;
            }
        }

        return count;
    }
}