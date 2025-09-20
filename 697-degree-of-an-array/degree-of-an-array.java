class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        Map<Integer,Integer> firstSeen = new HashMap<>();
        Map<Integer,Integer> lastSeen = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            firstSeen.putIfAbsent(nums[i],i);
            lastSeen.put(nums[i],i);
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }

        int degree = 0;
        for(int v : count.values()){
            degree = Math.max(degree,v);
        }

        int minLen = Integer.MAX_VALUE;
        for(int num : count.keySet()){
            if (count.get(num) == degree) {
                int len = lastSeen.get(num) - firstSeen.get(num) + 1;
                minLen = Math.min(minLen, len);
            }
        }
        return minLen;
    }
}