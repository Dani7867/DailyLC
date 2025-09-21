class Solution {
    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;

        int skipS = 0 ;
        int skipT = 0;

        while(p1>=0 || p2>=0){
                        // Find the next valid character in s
            while(p1>=0){
                if(s.charAt(p1) == '#'){
                    skipS++;
                    p1--;
                }else if(skipS > 0){
                    skipS--;
                    p1--;
                }else{
                    break; // as we found a valid ch
                }
            }

            while(p2>=0){
                if(t.charAt(p2) == '#'){
                    skipT++;
                    p2--;
                }else if(skipT > 0){
                    skipT--;
                    p2--;
                }else{
                    break; 
                }
            }
// If one pointer is valid and the other isn't, they are different
            if((p1>=0) != (p2>=0)){
                return false;
            }
            // If both are valid, but the characters don't match
            if(p1>=0 && p2>=0 && s.charAt(p1) != t.charAt(p2)){
                return false;
            }
            // Move to the next characters
            p1--;
            p2--;
        }
        return true;
    }
}