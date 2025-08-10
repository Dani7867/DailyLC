class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int p : piles){
            max = Math.max(max,p);
        }
        int lo = 1 , hi = max;
        while(lo<=hi){
            int speed = lo + (hi-lo) / 2;
            //if(canEat(piles,h,speed))
            //hi = mid-1;
            //lo = mid+1;

            long time = 0;
            for(int b : piles){
                time += Math.ceil((b*1.0)/speed);
            }
            if(time <= h){
                hi = speed-1;
            }else{
                lo = speed+1;
            }
        }
        return lo;
    }
}