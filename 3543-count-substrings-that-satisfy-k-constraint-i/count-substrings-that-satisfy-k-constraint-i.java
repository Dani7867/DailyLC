class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int ans = 0 ;

        for(int i = 0; i<n ; i++){
            int zC = 0 , oC = 0;
            for(int j = i ; j < n ; j++){
                if(s.charAt(j) == '0'){
                    zC++;
                }else{
                    oC++;
                }

                if(zC <= k || oC <=k){
                    ans++;
                }
            }
        }
        return ans;
    }
}