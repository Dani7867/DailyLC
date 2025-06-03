class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int n : map.keySet()){
            int c = map.get(n);
            res += (c*(c-1))/2;
        }
        return res;
    }
}