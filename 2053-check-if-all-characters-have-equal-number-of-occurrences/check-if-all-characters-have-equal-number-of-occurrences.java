class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] f = new int[26];
        for(char c : s.toCharArray()){
            f[c - 'a']++;
        }
        int x = 0;
        for(int n : f){
            if(n!=0 && x==0){
                x = n;
            }else if(n != 0){
                if(x!=n){
                    return false;
                }
            }
        }
        return true;
    }
}