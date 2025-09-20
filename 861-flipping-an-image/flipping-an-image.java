class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i = 0; i < image.length ; i++){
            for(int j = 0 ; j < image[0].length ; j++){
                if(image[i][j] == 0){
                    image[i][j] = 1;
                }else{
                    image[i][j] = 0;
                }
            }
        }

        for(int[] n : image){
            int r = n.length - 1;
            int l = 0;
            while(l<r){
                int t = n[r];
                n[r] = n[l];
                n[l] = t;
                l++;
                r--;
            }            
        }
        return image;
        
    }
}