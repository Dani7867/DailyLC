class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1 ) return word;
        int n = word.length();
        int len = n - numFriends + 1;
        char max = 'a';
        for(char ch : word.toCharArray()){
            if(ch>max) max = ch;
        }
         String res = "";
         for(int i = 0 ; i<n ; i++){
            if(word.charAt(i) == max){
                if(i + len <= n){
                    String sub = word.substring(i, i + len);
                    if (sub.compareTo(res) > 0) res = sub;
                } else {
                    String sub = word.substring(i);
                    if (sub.compareTo(res) > 0) res = sub;
                }
            }
         }
         return res;
    }
}