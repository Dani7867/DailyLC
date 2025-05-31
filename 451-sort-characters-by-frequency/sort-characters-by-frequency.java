class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        ArrayList<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)->(b.getValue()-a.getValue()));
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> c: list){
                Character a = c.getKey();
                Integer b = c.getValue();
                while(b>0){
                sb.append(a);
                b--;}
        }
        return sb.toString();
    }
}