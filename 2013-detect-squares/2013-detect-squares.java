class DetectSquares {

    private Map<String, Integer> points;

    public DetectSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        points.put(key, points.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int result = 0;

        for (String key : points.keySet()) {
            String[] parts = key.split(",");
            int px = Integer.parseInt(parts[0]);
            int py = Integer.parseInt(parts[1]);

            // diagonal point of a square
            if (Math.abs(px - x) != Math.abs(py - y) ||
                px == x || py == y) {
                continue;
            }

            int diagonal = points.get(key);

            int corner1 = points.getOrDefault(px + "," + y, 0);
            int corner2 = points.getOrDefault(x + "," + py, 0);

            result += diagonal * corner1 * corner2;
        }

        return result;
    }
}