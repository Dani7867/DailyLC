class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int l = 0,idx=0,idxj=0;
        for(int g = 0 ; g < s.length() ; g++){
            for(int i = 0 , j = g ; j < dp.length ; i++,j++){
                if(g==0){
                    dp[i][j] = true;
                }else if(g==1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j]){
                    if(g+1>l){
                        l = g+1;
                        idx = i;
                        idxj = j;
                    }
                }
            }
        }
        return s.substring(idx,idxj+1);
    }
}