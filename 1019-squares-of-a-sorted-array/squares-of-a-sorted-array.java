class Solution {
    public int[] sortedSquares(int[] nums) {
        // int[] arr = Arrays.stream(nums).map(i -> i*i).toArray();
        // Arrays.sort(arr);
        // return arr;

        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        for(int i = nums.length - 1 ; i>=0;i--){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                res[i] = nums[l] * nums[l];
                l++;
            }else{
                res[i] = nums[r] * nums[r];
                r--;
            }
        }

        return res;
    }
}