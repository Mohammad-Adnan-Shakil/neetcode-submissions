class CountSquares {
    private Map<String, Integer> cnt = new HashMap<>();
    private List<int[]> pts = new ArrayList<>();

    public CountSquares() {}

    public void add(int[] point) {
        cnt.merge(point[0] + "," + point[1], 1, Integer::sum);
        pts.add(new int[]{point[0], point[1]});
    }

    public int count(int[] point) {
        int qx = point[0], qy = point[1];
        int res = 0;
        for (int[] p : pts) {
            int px = p[0], py = p[1];
            if (Math.abs(px - qx) != Math.abs(py - qy) || px == qx) continue;
            res += cnt.getOrDefault(px + "," + qy, 0)
                 * cnt.getOrDefault(qx + "," + py, 0);
        }
        return res;
    }
}