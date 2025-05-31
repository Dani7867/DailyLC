class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0 , r = 0 , ans = 0 , win = 0;
        for(;r<s.length();r++){
            win += Math.abs(s.charAt(r) - t.charAt(r));
            while(win > maxCost){
                win = win - Math.abs(s.charAt(l) - t.charAt(l));
                l++;
               }
                ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}