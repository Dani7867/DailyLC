class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, sum = 0, res = 0;
        int[] arr = new int[n+1];
        arr[0] = 1;

        for(int i = 0; i < n; i++){
            sum += (nums[i] % 2);

            res += (sum >= k) ? arr[sum - k] : 0;

            arr[sum] += 1;
        }
        return res;
    }
}