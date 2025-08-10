class Solution {
    public int maxProfit(int[] prices) {
        int ob = -prices[0], os = 0 , oc = 0;
        for(int i = 1;  i<prices.length ; i++){
            int nb=0,ns=0,nc=0;

            nb = Math.max(ob,oc-prices[i]);
            ns = Math.max(os,ob+prices[i]);
            nc = Math.max(oc,os);

            ob = nb;
            os = ns;
            oc = nc;
        }
        return os;
    }
}