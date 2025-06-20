class Solution {
    public int missingNumber(int[] nums) {
        int asum = 0;
        int rsum = (nums.length*(nums.length+1))/2;
        for(int n : nums){
            asum+=n;
        }
       return rsum-asum;
    }
}