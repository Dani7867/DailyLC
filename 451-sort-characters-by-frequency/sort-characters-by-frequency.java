class Solution {
    public String frequencySort(String s) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c : s.toCharArray()) {
        freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }

    List<Character>[] buckets = new List[s.length() + 1];
    for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
        int freq = entry.getValue();
        if (buckets[freq] == null) {
            buckets[freq] = new ArrayList<>();
        }
        buckets[freq].add(entry.getKey());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = buckets.length - 1; i >= 0; i--) {
        if (buckets[i] != null) {
            for (char c : buckets[i]) {
                sb.append(String.valueOf(c).repeat(i)); 
            }
        }
    }

    return sb.toString();
}

}