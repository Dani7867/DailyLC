class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 0) return 0;
        int ml = 1 , inc = 1 , dec = 1;
        for(int i = 1 ; i< nums.length ; i++){
             if (nums[i] > nums[i-1]) { inc++; dec = 1; }      
            else if (nums[i] < nums[i-1]) { dec++; inc = 1; } 
            else { inc = 1; dec = 1; }                       
            ml = Math.max(ml, Math.max(inc, dec)); 
        }
        return ml;
    }
}