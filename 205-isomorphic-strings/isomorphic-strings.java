class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sM = new int[256];
        int[] tM = new int[256];
        Arrays.fill(sM,-1);
        Arrays.fill(tM,-1);
        for(int i = 0 ; i < s.length(); i++){
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if(sM[ss] == -1 && tM[tt] == -1){
                    sM[ss] = tt;
                    tM[tt] = ss;
            }else if(sM[ss] != tt || tM[tt] != ss){
                return false;
            }
        }
        return true;
    }
}