class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> oordinate = new HashSet<>();
        int x = 0 , y = 0 ;
        oordinate.add("0,0");
        for(char c : path.toCharArray()){
            if(c == 'N'){
                x++;
            }else if(c == 'S'){
                x--;
            }else if(c == 'E'){
                y++;
            }else if(c == 'W'){
                y--;
            }
            String co = x+","+y;
            if(oordinate.contains(co)){
                return true;
            }
            oordinate.add(co); 
        }
        return false;
    }
}