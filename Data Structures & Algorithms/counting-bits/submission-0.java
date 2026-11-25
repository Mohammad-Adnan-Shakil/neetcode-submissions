class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int x = i;
            int count = 0;
            while (x != 0) {
                count += x & 1;
                x >>>= 1;
            }
            result[i] = count;
        }
        return result;
    }
}