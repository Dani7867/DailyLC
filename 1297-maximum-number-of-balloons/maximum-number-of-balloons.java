class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : text.toCharArray()){
            if(c == 'b' || c == 'a'|| c == 'l' || c == 'o' || c == 'n'){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        int x = Math.min(map.getOrDefault('b',0),Math.min(map.getOrDefault('a',0),map.getOrDefault('n',0)));
        int xx = Math.min(map.getOrDefault('l',0),map.getOrDefault('o',0));

        return Math.min(xx/2,x);

    }
}