class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        int[] freqArr = new int[26];
        for(char c : order.toCharArray()){
            set.add(c);
        }
        for(char c : s.toCharArray()){
            if(!set.contains(c)){
                sb.append(c);
            }else{
                freqArr[c - 'a']++;
            }
        }
         for(char c : order.toCharArray()){
               int i = freqArr[c - 'a'];
               while(i>0){
                sb.append(c);
                i--;
               }
        }
        return sb.toString();
    }
}