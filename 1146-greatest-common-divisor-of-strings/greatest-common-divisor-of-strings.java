class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if((str1+str2).equals(str2+str1)){
            int a = str1.length();
            int b = str2.length();
            int gcd = gcd(a,b);
            return str1.substring(0,gcd);
        }else{
            return "";
        }
    }

    private int gcd(int a , int b){
        while(a%b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return b;
    }
}