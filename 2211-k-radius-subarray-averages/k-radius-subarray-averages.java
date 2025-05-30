class Solution {
    public int[] getAverages(int[] nums, int k) {
        int idx = 2*k + 1;
        long window = 0;
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        if(idx>nums.length) return ans;
        int center = k;
        for(int i = 0 ; i<idx ; i++){
            window+=nums[i];
        }
        ans[center] = (int)(window/idx);
        for(int i = idx ; i<nums.length ; i++){
            window = window - nums[i - idx] + nums[i];
            ans[++center] = (int)(window/idx);
        }
        return ans;
    }
}