class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int l = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int v : map.keySet()){
            if(map.get(v) > l/3){
                list.add(v);
            }
        }
        return list;
    }
}