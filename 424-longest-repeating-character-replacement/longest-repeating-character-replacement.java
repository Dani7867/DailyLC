class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0 , res = 0;
        for(int r = 0;r<s.length();r++){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
           
            if(r-l+1-Collections.max(map.values())>k){
                char chl = s.charAt(l);
                map.put(chl,map.getOrDefault(chl,0)-1);
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}