class Solution {
    public String minWindow(String s, String t) {
        // HashMap<Character,Integer> map = t.chars().mapToObj(c -> (char)c)
        //                                   .collect(Collectors.groupingBy(
        //                                     Function.identity(),
        //                                     HashMap::new,
        //                                     Collectors.collectingAndThen(
        //                                         Collectors.counting(),
        //                                         Long::intValue
        //                                     )
        //                                   ));
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){ map.put(c,map.getOrDefault(c,0)+1); }
        HashMap<Character,Integer> map1 = new HashMap<>();
        int mct = 0 , dmct = t.length();
        int i = -1 , j=-1;
        String ans = "";
        while(true){
            boolean flag1 = false, flag2 = false;

            //accquire
            while(i < s.length() - 1 && mct < dmct){
                i++;
                char ch = s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);

                if(map1.getOrDefault(ch,0) <= map.getOrDefault(ch,0)){
                    mct++;
                }
                flag1 = true;
                
            }
            // release
            while(j < i && mct == dmct){
                String pans = s.substring(j+1,i+1);
                if(ans.length() == 0 || pans.length() < ans.length()){
                    ans = pans;
                }
                j++;
                char ch = s.charAt(j);
                
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                }else{
                    map1.put(ch,map1.get(ch)-1);
                }

                if(map1.getOrDefault(ch,0) < map.getOrDefault(ch,0)){
                    mct--;
                }
                flag2 = true;

            }

            if(flag1 == false && flag2 == false){
                break;
            } 

        }
        return ans;
    }
}