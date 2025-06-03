class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int c = 0;
        for(int n : map.keySet()){
            if(map.get(n) == 1){
                c += n;
            }
        }
        return c;
    }
}