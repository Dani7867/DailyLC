class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int fi = -1 , li = -1 ,max = 0;
        // first and last index of 1
        for(int i = 0 ; i < flowerbed.length ; i++){
            if(flowerbed[i] == 0){
                continue;
            }else if(fi == -1){
                fi = i;
                li = i;
            }else{
                li = i;
            }
        }

        if(fi==-1){
            return (flowerbed.length+1)/2 >= n;
        }
        // no of zeros before , after 1
        max = fi / 2;
        max += (flowerbed.length-li-1)/2;

        //middle part 1.......1
        int c = 0;
        for(int i = fi+1 ; i<=li-1 ;i++){
            if(flowerbed[i] == 0){
                c++;
            }else{
                max += (c-1)/2;
                c = 0;
            }
        }

        max += (c-1)/2;

        return max >= n;
    }
}