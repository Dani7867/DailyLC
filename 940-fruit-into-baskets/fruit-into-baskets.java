class Solution {
    public int totalFruit(int[] fruits) {
        int s = 0 , e = 0 , maxL = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(e<fruits.length){
            map.put(fruits[e],map.getOrDefault(fruits[e],0)+1);
            while(map.size() >= 3){
                 map.put(fruits[s],map.getOrDefault(fruits[s],0)-1);
                 if(map.get(fruits[s]) == 0) map.remove(fruits[s]);
                 s++;
            }
            int currL = e-s+1;
            maxL = Math.max(maxL,currL);
            e++;
        }
        return maxL;
    }
}