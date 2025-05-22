class Solution {
    public int subtractProductAndSum(int n) {
        int s = sumD(n);
        int p = prodD(n);
        return p - s;
    }

    private int sumD(int n){
        int y = 0;
        while(n>0){
            int x = n%10;
            y += x;
            n/=10;
        }
        return y;
    }

    private int prodD(int n){
        int y = 1;
        while(n>0){
            int x = n%10;
            y *= x;
            n/=10;
        }
        return y;
    }
}