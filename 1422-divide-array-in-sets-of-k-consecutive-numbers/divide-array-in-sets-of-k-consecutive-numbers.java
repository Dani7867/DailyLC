class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0 ) return false;
        TreeMap<Integer,Integer> sortedMap = new TreeMap<>();
        for(int n : nums) sortedMap.put(n,sortedMap.getOrDefault(n,0)+1);
        while(!sortedMap.isEmpty()){
            int min = sortedMap.firstKey();
            for(int i = 0 ; i<k ; i++){
                int consMin = min + i;
                if(!sortedMap.containsKey(consMin)) return false;
                sortedMap.put(consMin,sortedMap.get(consMin)-1);
                if(sortedMap.get(consMin) == 0){
                    sortedMap.remove(consMin);
                }
            }
        }
        return true;
    }
}