class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int win = 0;
        int l = 0;
        int ans = nums.length + 1;
        for(int i = 0 ; i<nums.length;i++){
            win += nums[i];
            while(win >= target){
                ans = Math.min(ans,i-l+1);
                win -= nums[l++];
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
}