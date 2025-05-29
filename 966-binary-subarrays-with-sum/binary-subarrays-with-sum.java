class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int psum = 0;
        int ans = 0;
        map.put(0,1);
        for(int i = 0 ; i< nums.length ; i++){
            psum += nums[i];
            ans += map.getOrDefault(psum-goal,0);
            map.put(psum,map.getOrDefault(psum,0)+1);
        }

        return ans;
    }
}