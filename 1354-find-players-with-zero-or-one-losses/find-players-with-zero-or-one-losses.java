class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> zeroL = new ArrayList<>();
        List<Integer> oneL = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] t : matches){
            map.put(t[0],map.getOrDefault(t[0],0));
            map.put(t[1],map.getOrDefault(t[1],0)+1);
        }
        for(int i : map.keySet()){
            if(map.get(i) == 0){
                zeroL.add(i);
            }else if(map.get(i) == 1){
                oneL.add(i);
            }
        }
        Collections.sort(zeroL);
        Collections.sort(oneL);
        return Arrays.asList(zeroL,oneL);
    }
}