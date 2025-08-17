class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0 , r = 0 , res = 0;
        int maxF = 0;
        for(;r<s.length();r++){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxF = Math.max(maxF,map.get(ch));
            if(r-l+1-maxF>k){
                char chl = s.charAt(l);
                map.put(chl,map.getOrDefault(chl,0)-1);
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}