class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int m = Integer.MIN_VALUE;
        for(int n : nums){
            m = Math.max(m,n);
        }

        int lo  = 1 , hi = m;
        int ans = Integer.MAX_VALUE;
        while(lo<=hi){
            int mid = lo + (hi-lo) / 2;
            long t = 0L;
            for(int p : nums){
                t += (int)Math.ceil(p*1.0/mid);
            }
            if(t <= threshold){
                ans = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        return ans;
    }
}