class Solution {
    public boolean isHappy(int n) {
        int s = n;
        int f = getNext(n);
        do{
            s = getNext(s);
            f = getNext(getNext(f));
        }while(s!=f);

        return s == 1;
    }

    private int getNext(int n){
        int t = 0;
        while(n>0){
            int d = n % 10;
            t += d*d;
            n /= 10;
        }
        return t;
    }
}