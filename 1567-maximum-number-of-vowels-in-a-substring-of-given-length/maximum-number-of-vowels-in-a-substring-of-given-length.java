class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        int win = 0;
        for(int i = 0 ; i<k ; i++){
            if(isVowel(s.charAt(i))){
                win++;
            }
        }
        ans = win;
        for(int j = k ; j<s.length() ; j++){
            if(isVowel(s.charAt(j))){
                win++;
            }
            if(isVowel(s.charAt(j-k))){
                win--;
                }
            ans = Math.max(ans,win);
        }
        return ans;
    }
    boolean isVowel(char c){
        return c == 'u' || c=='o' || c == 'i' || c == 'a' || c == 'e';
    }
}