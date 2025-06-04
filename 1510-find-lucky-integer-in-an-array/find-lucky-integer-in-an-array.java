class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int largest = -1;
        for(int n : arr){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int n : map.keySet()){
            if(n == map.get(n)){
                largest = Math.max(largest,n);
            }
        }
        
        return largest;
    }
}