class Solution {
    public int countBinarySubstrings(String s) {
         if (s == null || s.length() == 0) {
            return 0;
        }
        int prevGrpCount = 0 , currGrpCount = 1 , ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)){
                currGrpCount++;
            }else{
                ans += Math.min(prevGrpCount,currGrpCount);
                prevGrpCount = currGrpCount;
                currGrpCount = 1;
            }
        }
        ans += Math.min(prevGrpCount,currGrpCount); // Ahh! dont miss the last group 
        return ans;
    }
}