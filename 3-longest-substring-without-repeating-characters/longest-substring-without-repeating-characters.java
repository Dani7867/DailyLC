class Solution {
    public int lengthOfLongestSubstring(String s) {
      HashMap<Character,Integer> map = new HashMap<>();
      char[] ch = s.toCharArray();
      int left = 0 , right = 0 , maxL = 0;
      for(;right<s.length();right++){
        int idx = map.getOrDefault(ch[right],-1);
        if(idx != -1 && idx >= left){
            maxL = Math.max(maxL,right  - left );
            left = idx +1 ;
        }
        map.put(ch[right],right);
      }
      return Math.max(maxL,right -left);
    }
}