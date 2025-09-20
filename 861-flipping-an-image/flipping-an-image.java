class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] n : image){
            int r = n.length - 1;
            int l = 0;
            while(l<r){
                int t = n[r];
                n[r] = n[l] ^ 1; // ^ 1' inverts the bit
                n[l] = t ^ 1;
                l++;
                r--;
            }       

            if(l == r){ // handle odd case
                n[l] = n[l] ^ 1; 
            }     
        }
        return image;
        
    }
}