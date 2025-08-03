class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int lastPos = fruits[n - 1][0];
        int firstPos = fruits[0][0];

        int[] pref = new int[(int)Math.max(startPos, lastPos) + 1];
        pref[firstPos] = fruits[0][1];
        int j = 1;
        
        for (int i = firstPos + 1; i <= (int)Math.max(startPos, lastPos); i++) {
            if (j < n && fruits[j][0] == i) {
                pref[i] = pref[i - 1] + fruits[j][1];
                j++;
            } else {
                pref[i] = pref[i - 1];
            }
        }

        long max = 0;

        // Right twice
        for (int i = startPos; i <= Math.min(startPos + k, lastPos); i++) {
            long cur = 0;
            int k1 = k;
            int p = (startPos != 0) ? pref[startPos - 1] : 0;
            cur = (pref[i] - p);
            k1 -= (i - startPos) * 2;

            if (startPos > 0 && k1 > 0) {
                int posReached = startPos - k1;
                if (posReached > 0) p = pref[posReached - 1];
                else p = 0;
                cur += (pref[startPos - 1] - p);
            }

            max = Math.max(max, cur);
        }

        // Left twice
        for (int i = startPos; i >= Math.max(startPos - k, firstPos); i--) {
            long cur = 0;
            int k1 = k;
            int p = (i > 0) ? pref[i - 1] : 0;
            cur = (pref[startPos] - p);
            k1 -= (startPos - i) * 2;

            if (startPos < lastPos && k1 > 0) {
                int posReached = startPos + k1;
                if (posReached <= lastPos) p = pref[posReached];
                else p = pref[lastPos];
                cur += (p - pref[startPos]);
            }

            max = Math.max(max, cur);
        }

        return (int) max;
    }
}