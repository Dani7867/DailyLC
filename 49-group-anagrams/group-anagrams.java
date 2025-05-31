class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String w : strs){
            char[] ch = w.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);

            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }

            map.get(s).add(w);
        }
        return new ArrayList<>(map.values());
    }
}