class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        List<Character> v = new ArrayList<>();

        for(char c : s.toCharArray()){
            if(vowels.contains(c))
                v.add(c);
        }

        Collections.sort(v);

        StringBuilder res = new StringBuilder();
        int idx = 0;

        for(char c : s.toCharArray()){
            if(vowels.contains(c)){
                res.append(v.get(idx++));
            }else{
                res.append(c);
            }
        }

        return res.toString();

    }
}