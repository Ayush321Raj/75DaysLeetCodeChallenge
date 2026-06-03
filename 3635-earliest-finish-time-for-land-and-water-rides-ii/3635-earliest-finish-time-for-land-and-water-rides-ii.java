import java.util.*;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                      waterStartTime, waterDuration));

        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                      landStartTime, landDuration));

        return (int) ans;
    }

    private long solve(int[] firstStart, int[] firstDuration,
                       int[] secondStart, int[] secondDuration) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];

        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDuration[i];
        }

        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        int[] starts = new int[m];
        long[] prefixMinDuration = new long[m];
        long[] suffixMinFinish = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefixMinDuration[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDuration[i] =
                    Math.min(prefixMinDuration[i - 1], rides[i][1]);
        }

        suffixMinFinish[m - 1] =
                (long) rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMinFinish[i] = Math.min(
                    suffixMinFinish[i + 1],
                    (long) rides[i][0] + rides[i][1]
            );
        }

        long result = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            long finishFirst =
                    (long) firstStart[i] + firstDuration[i];

            int idx = upperBound(starts, (int) finishFirst) - 1;

            long best = Long.MAX_VALUE;

            if (idx >= 0) {
                best = Math.min(
                        best,
                        finishFirst + prefixMinDuration[idx]
                );
            }

            if (idx + 1 < m) {
                best = Math.min(
                        best,
                        suffixMinFinish[idx + 1]
                );
            }

            result = Math.min(result, best);
        }

        return result;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}