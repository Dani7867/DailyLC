class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;
        double res = 0;
        double win = 0;
        for(int i = 0 ; i < k ;i++){
            win += nums[i];
        }
        res = win/k;
        for(int right = k ; right < nums.length ; right++){
            win = win  - nums[right - k] + nums[right];
            res = Math.max(res,win/k);
        }
    return res;
    }
}