class Solution {
    public boolean isPalindrome(String s) {
        //s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        char[] temp = new char[s.length()];
        int l = 0;
        for(int i = 0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            if(c>='A' && c<='Z'){
                temp[l++] = (char) (c+32);
            }else if(c>='a' && c<='z'){
                temp[l++] = c;
            }else if(c>='0' && c<='9'){
                temp[l++] = c;
            }
        }
        for(int i = 0 ; i < l/2 ; i++){
            if(temp[i] != temp[l - i - 1]){
                return false;
            }
        }
        return true;
    }
}