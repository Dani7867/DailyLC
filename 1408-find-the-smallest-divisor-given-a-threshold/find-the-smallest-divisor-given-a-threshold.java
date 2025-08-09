class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int p : nums) {
            max = Math.max(max, p);
        }
        
        int l = 1, hi = max;
        int minS = max; // worst case
        
        while (l <= hi) {
            int s = l + (hi - l) / 2;
            if (canFinish(nums, threshold , s)) {
                minS = s;
                hi = s - 1;
            } else {
                l = s + 1;
            }
        }
        return minS;
    }

    private boolean canFinish(int[] piles, int h , int s) {
        long hours = 0L;                       // must be long to avoid overflow
        for (int p : piles) {
            hours += (p + s - 1) / s;         // integer ceiling
            if (hours > h) return false;     // early exit
        }
        return hours <= h;
    }
}

