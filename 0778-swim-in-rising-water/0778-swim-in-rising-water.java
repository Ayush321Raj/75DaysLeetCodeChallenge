class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // dist[i][j] = minimum possible maximum elevation
        // needed to reach (i, j)
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // {time, row, col}
        dist[0][0] = grid[0][0];
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int time = current[0];
            int r = current[1];
            int c = current[2];

            // Reached destination
            if (r == n - 1 && c == n - 1) {
                return time;
            }

            // Skip outdated entry
            if (time > dist[r][c]) {
                continue;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                int newTime = Math.max(time, grid[nr][nc]);

                if (newTime < dist[nr][nc]) {
                    dist[nr][nc] = newTime;
                    pq.offer(new int[]{newTime, nr, nc});
                }
            }
        }

        return -1;
    }
}