class Solution {
    public int longestSubarray(int[] nums) {
        int size = 0, res = 0, curMax = 0;

        for (int n : nums) {
            if (n > curMax) {
                curMax = n;
                size = 1;
                res = 0;
            } else if (n == curMax) {
                size += 1;
            } else {
                size = 0;
            }
            res = Math.max(res, size);
        }

        return res;
    }
}