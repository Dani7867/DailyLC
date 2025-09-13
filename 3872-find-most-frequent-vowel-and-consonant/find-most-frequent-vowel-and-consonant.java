class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> vowel = new HashMap<>();
        HashMap<Character,Integer> consonant = new HashMap<>();

        for(char c : s.toCharArray()){
            if(c == 'a' || c == 'e'||c == 'i' || c == 'o'||c == 'u'){
                vowel.put(c,vowel.getOrDefault(c,0)+1);
            }else{
                consonant.put(c,consonant.getOrDefault(c,0)+1);
            }
        }

        int a = 0 , b = 0;
        for(int i : vowel.values()){
            a = Math.max(i,a);
        }
        for(int i : consonant.values()){
            b = Math.max(i,b);
        }

        return a+b;
    }
}