class Solution {
    public String reverseVowels(String s) {
        int i = 0 , j = s.length() - 1;
        char[] ch = s.toCharArray();
        while(i<j){
              if(isVowel(ch[i]) && isVowel(ch[j])){
                char t = ch[i];
                ch[i] = ch[j];
                ch[j] = t;
                i++;
                j--;
              }else if(isVowel(ch[i])){
                j--;
              }else if(isVowel(ch[j])){
                i++;
              }else{
                i++;
                j--;
              }
            }
            return new String(ch);
        }

    private boolean isVowel(char c){
        if(c == 'a' || c == 'A'){
            return true;
        }else if(c == 'e' || c == 'E'){
            return true;
        }else if(c == 'i' || c == 'I'){
            return true;
        }else if(c == 'o' || c == 'O'){
            return true;
        }else if(c == 'u' || c == 'U'){
            return true;
        }else{
            return false;
        }
    }
}