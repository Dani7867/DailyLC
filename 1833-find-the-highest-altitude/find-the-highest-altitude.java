class Solution {
    public int largestAltitude(int[] gain) {
        int[] ps = new int[gain.length+1];
        ps[0] = gain[0];
        int m = Integer.MIN_VALUE;;
        for(int i = 1; i<gain.length; i++){
            ps[i] += gain[i] + ps[i-1];
        }
        for(int n : ps){
             m = Math.max(m,n);
        }
        return m;
    }
}