class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0 ;
        int len1 = word1.length();
        int len2 = word2.length();

        while (i < len1 && i < len2) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        while(i<len1){
            sb.append(word1.charAt(i));
            i++;
        }
        while(i<len2){
            sb.append(word2.charAt(i));
            i++;
        }
    return sb.toString();
    }
}