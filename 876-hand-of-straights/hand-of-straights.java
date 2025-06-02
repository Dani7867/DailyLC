class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        TreeMap<Integer,Integer> sortedMap = new TreeMap<>();
        for(int n : hand){
            sortedMap.put(n,sortedMap.getOrDefault(n,0)+1);
        }
        while(!sortedMap.isEmpty()){
            int smallest = sortedMap.firstKey();
            for(int i = 0 ; i < groupSize;i++){
                int next = smallest+i;
                if (!sortedMap.containsKey(next)) return false;
                sortedMap.put(next, sortedMap.get(next) - 1);
                if (sortedMap.get(next) == 0) {
                    sortedMap.remove(next);
            }
            }
        }
        return true;
    }
}