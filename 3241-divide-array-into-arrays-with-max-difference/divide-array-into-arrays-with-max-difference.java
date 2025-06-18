class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);  
        int n = nums.length;
        if (n % 3 != 0) return new int[0][0];  

        int[][] res = new int[n / 3][3];
        int index = 0;

        for(int i = 0 ; i < n ; i+=3){
            int min = nums[i];
            int max = nums[i+2];
            if(max-min > k){
                return new int[0][0];
            }
            res[index++] = new int[]{nums[i],nums[i+1],nums[i+2]};
        }
        return res;
    }
}