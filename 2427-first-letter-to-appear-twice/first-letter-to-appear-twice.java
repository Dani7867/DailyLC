class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();   //O(26) in this case

        for(char c : s.toCharArray()){      //O(n)
            if(set.contains(c)){
                return c;
            }else{
                set.add(c);
            }
        }
        return 'q'; 
    }
}