class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int[] a : nums){
            for(int i : a){
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }

        return map.keySet().stream().filter(i -> map.get(i) == n).sorted().collect(Collectors.toList());
    }
}