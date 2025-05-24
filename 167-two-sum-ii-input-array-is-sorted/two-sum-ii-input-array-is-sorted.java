class Solution {
    public int[] twoSum(int[] arr, int target) {
        int l = 0 , r = arr.length - 1 ;
        while(l<r){
            if(arr[l] + arr[r] > target){
                r--;
            }else if(arr[l] + arr[r] < target){
                l++;
            }else{
                return new int[]{l+1,r+1};
            }
        }
        return new int[]{};
    }
}