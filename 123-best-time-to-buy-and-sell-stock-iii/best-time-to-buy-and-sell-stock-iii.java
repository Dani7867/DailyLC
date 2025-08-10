class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mpist = 0;
        int lsf = prices[0];
        int[] dpl = new int[n];

        for(int i = 1 ; i < n ; i++){
            lsf = Math.min(lsf,prices[i]);
            mpist = prices[i] - lsf;
            dpl[i] = Math.max(mpist,dpl[i-1]);
        }

        int mpibt = 0;
        int msf = prices[n-1];
        int[] dpr = new int[n];

        for(int i = n - 2 ; i >= 0 ; i--){
            msf = Math.max(msf,prices[i]);
            mpibt = msf - prices[i];
            dpr[i] = Math.max(mpibt,dpr[i+1]);
        }

        int op = 0;
        for(int i = 0 ; i < n ; i++){
            op = Math.max(dpl[i]+dpr[i],op);
        }

        return op;
    }
}