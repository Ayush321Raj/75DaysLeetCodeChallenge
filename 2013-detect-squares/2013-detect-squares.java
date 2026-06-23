class DetectSquares {

    Map<Integer, Map<Integer, Integer>> cnt = new HashMap<>();

    public DetectSquares() {}

    public void add(int[] point) {
        int x = point[0], y = point[1];
        cnt.computeIfAbsent(x, k -> new HashMap<>());
        cnt.get(x).put(y, cnt.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];

        if (!cnt.containsKey(x)) return 0;

        int res = 0;

        for (int col : cnt.keySet()) {
            if (col == x) continue;

            int d = col - x;

            int c1 = cnt.get(col).getOrDefault(y, 0);

            res += c1 *
                   cnt.get(x).getOrDefault(y + d, 0) *
                   cnt.get(col).getOrDefault(y + d, 0);

            res += c1 *
                   cnt.get(x).getOrDefault(y - d, 0) *
                   cnt.get(col).getOrDefault(y - d, 0);
        }

        return res;
    }
}