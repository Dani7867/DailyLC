class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        for(char j : t.toCharArray()){
            freq[j - 'a']--;
        }
        for(int n : freq){
            if(n>0 || n<0){
                return false;
            }
        }
        return true;
    }
}