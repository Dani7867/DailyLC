class Solution {
    public int majorityElement(int[] nums) {
        int c = findME(nums);
        if(isME(nums,c)){
            return c;
        }

        return -1;
    }

    int findME(int[] nums){
        int c = 0;
        int a = 0;
        for(int x : nums){
            if(c == 0){
                a = x;
            }

            c += (a==x) ? 1 : -1; 
        }

        return a;
    }

    boolean isME(int[] nums ,int a ){
        int c = 0;
        for(int x : nums){
            if(a==x){
                c++;
            }
        }

        return c>nums.length/2 ? true : false;
    }
}