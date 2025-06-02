class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int csum = 0;
        int res = 0;
        map.put(0,1);
        for(int n : nums){
            csum += n%2;
            res += map.getOrDefault(csum-k,0);
            map.put(csum,map.getOrDefault(csum,0)+1);
        }
        return res;
    }
}