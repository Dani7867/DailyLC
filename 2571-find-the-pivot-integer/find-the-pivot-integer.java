class Solution {
    public int pivotInteger(int n) {
        for(int i = 1 ; i<=n ; i++){
            int p = i;
            if((p*(p+1))/2 == ((n*(n+1))/2 - (p*(p-1))/2)){
                return p;
            }
        }
        return -1;
    }
}