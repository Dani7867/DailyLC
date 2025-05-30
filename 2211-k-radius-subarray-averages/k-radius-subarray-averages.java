class Solution {
    public int[] getAverages(int[] nums, int k) {
    int n = nums.length;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);

    if (2 * k + 1 > n) return ans;

    long[] prefix = new long[n + 1]; // 1-based for easier range sum
    for (int i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }

    for (int i = k; i <= n - k - 1; i++) {
        long total = prefix[i + k + 1] - prefix[i - k];
        ans[i] = (int)(total / (2 * k + 1));
    }

    return ans;
}

}