class Solution {
    public int findLHS(int[] nums){
        int l = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int i : map.keySet()){
            if(map.containsKey(i+1)){
                l = Math.max(l,map.get(i+1) + map.get(i));
            }
        }
        return l;
    }
}   
    // public int findLHS(int[] nums) {
    //     int l = 0 , ans = 0 , window = 0;
    //     Arrays.sort(nums);
    //     for(int r = 0 ; r<nums.length ; r++){
    //         while(nums[r] - nums[l] > 1){
    //             l++;
    //         }
    //         if (nums[r] - nums[l] == 1) {
    //              ans = Math.max(ans, r - l + 1);
    //         }
    //     }
    //     return ans;
    // }
