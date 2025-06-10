class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        int odd = Integer.MIN_VALUE;
        int even = Integer.MAX_VALUE;
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        for(int n : freq){
            if(n%2 == 0 && n!=0){
                even = Math.min(even,n);
            }else{
                odd = Math.max(odd,n);
            }
        }

        return odd - even;
    }
}