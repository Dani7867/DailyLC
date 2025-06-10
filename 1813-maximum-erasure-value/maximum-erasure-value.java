class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0,res=0,sum=0;
        Set<Integer> set = new HashSet<>();
        for(int r = 0 ; r<nums.length ; r++){
            while(set.contains(nums[r])){
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            sum += nums[r];
            set.add(nums[r]);
            res = Math.max(res,sum);

        }
        return res;
    }
}