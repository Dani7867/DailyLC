class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = -1 , j = -1,len = 0;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            // acquire
            while(i < s.length() - 1){
                flag1 = true;
                i++;
                char c = s.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
                if(map.get(c) == 2){
                    break;
                }else{
                    len = Math.max(len,i-j);
                }
            }
            // release
            while(j<i){
                flag2 = true;
                j++;
                char c = s.charAt(j);
                map.put(c,map.getOrDefault(c,0)-1);
                if(map.get(c) == 1){
                    break;
                }

            }
            if(flag1 == false && flag2 == false) break;
        }

        return len;
    }
}