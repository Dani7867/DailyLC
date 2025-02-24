class Solution {
    public int numberOfSteps(int num) {
        return steps(num , 0);
    }

    static int steps(int num , int step){
        if(num == 0) return step;

        if(num % 2 == 0) return steps(num/2 , step+1);
        else return steps(num - 1 , step+1);
    }
}