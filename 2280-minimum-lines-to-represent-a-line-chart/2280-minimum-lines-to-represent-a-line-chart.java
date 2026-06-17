class Solution {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;

        if (n <= 1) return 0;

        Arrays.sort(stockPrices, (a, b) -> Integer.compare(a[0], b[0]));

        int lines = 1;

        for (int i = 2; i < n; i++) {
            long dy1 = (long) stockPrices[i - 1][1] - stockPrices[i - 2][1];
            long dx1 = (long) stockPrices[i - 1][0] - stockPrices[i - 2][0];

            long dy2 = (long) stockPrices[i][1] - stockPrices[i - 1][1];
            long dx2 = (long) stockPrices[i][0] - stockPrices[i - 1][0];

            if (dy1 * dx2 != dy2 * dx1) {
                lines++;
            }
        }

        return lines;
    }
}