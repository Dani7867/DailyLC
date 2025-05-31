class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for(String word : strs){
            boolean placed = false;
            for(List<String> group : result){
                if(isAnagram(group.get(0),word)){
                    group.add(word);
                    placed = true;
                    break;
                }
            }

            if(!placed){
                List<String> nGroup = new ArrayList<>();
                nGroup.add(word);
                result.add(nGroup);
            }
        }
        return result;
    }

    private boolean isAnagram(String s1 , String s2){
        if (s1.length() != s2.length()) return false;
        int[] freq = new int[26];
        for(char c : s1.toCharArray()) freq[c - 'a']++;
        for(char c : s2.toCharArray()) freq[c - 'a']--;

        for(int n : freq){
            if(n!=0){
                return false;
            }
        }
        return true;

    }
}