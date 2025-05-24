class Solution{
    public boolean isSubsequence(String s , String t){
        int i = 0 ,j = 0;
        while(i<s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}



//O(2^n)
// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         return isSub("",t,s);
//     }

//     boolean isSub(String p , String up , String s){
//         if(up.isEmpty()){
//             return (p.equals(s));
//         }

//         char a = up.charAt(0);

//         return isSub(p+a,up.substring(1),s) || isSub(p,up.substring(1),s);
//     }
// }
