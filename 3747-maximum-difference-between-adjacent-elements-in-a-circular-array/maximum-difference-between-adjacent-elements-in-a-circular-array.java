class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int res = Math.abs(nums[nums.length -1] - nums[0]);
        for(int i = 1 ; i<nums.length ; i++){
            int diff = Math.abs(nums[i -1] - nums[i]);
            res = Math.max(res,diff);
        }
        return res;
    }
}