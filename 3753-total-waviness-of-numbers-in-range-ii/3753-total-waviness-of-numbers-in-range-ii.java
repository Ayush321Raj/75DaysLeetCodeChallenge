import java.util.*;

class Solution {

    static class Pair {
        long count;
        long sum;

        Pair(long count, long sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    private char[] digits;
    private Pair[][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) return 0;

        digits = String.valueOf(n).toCharArray();

        int len = digits.length;

        memo = new Pair[len][3][11][11];

        return dfs(0, 0, 10, 10, true).sum;
    }

    private Pair dfs(int pos,
                     int state,
                     int prev1,
                     int prev2,
                     boolean tight) {

        if (pos == digits.length) {
            return new Pair(1, 0);
        }

        if (!tight && memo[pos][state][prev1][prev2] != null) {
            return memo[pos][state][prev1][prev2];
        }

        int limit = tight ? digits[pos] - '0' : 9;

        long totalCount = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {

            boolean nextTight = tight && (d == limit);

            int nextState;
            int nextPrev1;
            int nextPrev2;

            long add = 0;

            if (state == 0) {

                if (d == 0) {
                    nextState = 0;
                    nextPrev1 = 10;
                    nextPrev2 = 10;
                } else {
                    nextState = 1;
                    nextPrev1 = d;
                    nextPrev2 = 10;
                }

            } else if (state == 1) {

                nextState = 2;
                nextPrev2 = prev1;
                nextPrev1 = d;

            } else {

                if ((prev1 > prev2 && prev1 > d) ||
                    (prev1 < prev2 && prev1 < d)) {
                    add = 1;
                }

                nextState = 2;
                nextPrev2 = prev1;
                nextPrev1 = d;
            }

            Pair child = dfs(
                    pos + 1,
                    nextState,
                    nextPrev1,
                    nextPrev2,
                    nextTight
            );

            totalCount += child.count;
            totalSum += child.sum + add * child.count;
        }

        Pair res = new Pair(totalCount, totalSum);

        if (!tight) {
            memo[pos][state][prev1][prev2] = res;
        }

        return res;
    }
}