class Solution {
    public int pivotIndex(int[] nums) {
        int[] p = new int[nums.length];
        int[] s = new int[nums.length];

        // Prefix sum: p[i] = sum of nums[0] to nums[i-1]
        p[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            p[i] = p[i - 1] + nums[i - 1];
        }

        // Suffix sum: s[i] = sum of nums[i+1] to nums[end]
        s[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            s[i] = s[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (p[i] == s[i]) {
                return i; // Found the pivot index
            }
        }

        return -1;

    }
}