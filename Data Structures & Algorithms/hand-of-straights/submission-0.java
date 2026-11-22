class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }
        while (!count.isEmpty()) {
            int start = count.firstKey();
            for (int c = start; c < start + groupSize; c++) {
                Integer have = count.get(c);
                if (have == null) return false;
                if (have == 1) count.remove(c);
                else count.put(c, have - 1);
            }
        }
        return true;
    }
}