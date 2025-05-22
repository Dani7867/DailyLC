class Solution {
    public boolean isSameAfterReversals(int num) {
        long y = 0 ;
        int temp = num;
        while(temp>0){
            y = (y*10)+(temp%10);
            temp = temp/10;
        }
       long n  = 0 ;
        while(y>0){
            n = (n*10)+(y%10);
            y = y/10;
        }

        return (n==num) ? true : false;
    }
}