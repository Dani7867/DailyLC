class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int p : piles){
            max = Math.max(max,p);
        }
        int l = 1 , hi = max;
        int minS = Integer.MAX_VALUE;
        while(l<=hi){
            int s = l + (hi-l) / 2;
            if(possible(piles,s,h)){
                minS = s;
                hi = s - 1;
            }else{
                l = s + 1;
            }
        }
        return minS;
    }

    private boolean possible(int[] piles , int s , int h){
        long time = 0L;
        for(int i = 0 ; i <  piles.length ; i++){
             time += (piles[i] + s - 1) / s;
        }
        return time <= h;
    }
}