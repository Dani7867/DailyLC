class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Check if lengths are equal
        if (word1.length() != word2.length()) {
            return false;
        }
        
        // Use HashMap to store character frequencies
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        // Populate map1 with word1 frequencies
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        
        // Populate map2 with word2 frequencies
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        
        // Check if key sets (characters) are the same
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        
        // Compare sorted frequency counts
        return map1.values().stream().sorted().toList()
                .equals(map2.values().stream().sorted().toList());
    }
}