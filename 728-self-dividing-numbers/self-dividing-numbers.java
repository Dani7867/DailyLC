class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left ; i<=right ; i++){
            if(selfdiv(i)){
                res.add(i);
            }
        }
        return res;
    }
    private boolean selfdiv(int num){
        int temp = num;
        while(num!=0){
            int rem = num%10;
            if(rem == 0){
                return false;
            }
            if(temp%rem!=0){
                return false;
            }
            num = num/10;
        }
        return true;
    }
}