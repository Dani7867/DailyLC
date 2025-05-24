class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (sum < 0) {
                sum += k; 
            }
            if(map.containsKey(sum)){
                if(i - map.get(sum) >= 2){
                    return true;
                }
            }else{
                map.put(sum,i);
            }



        }
        return false;
    }
}



// tle error
// class Solution {
//     public boolean checkSubarraySum(int[] nums, int k) {
//         if (nums.length < 2) return false;
        
//         int[] prefixSum = new int[nums.length + 1];
//         prefixSum[0] = 0; 
//         for (int i = 0; i < nums.length; i++) {
//             prefixSum[i + 1] = prefixSum[i] + nums[i];
//         }

//         // Check all subarrays with length >= 2
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) { // Ensure length >= 2
//                 int subarraySum = prefixSum[j + 1] - prefixSum[i];
//                 if (k == 0) {
//                     if (subarraySum == 0) return true;
//                 } else if (subarraySum % k == 0) {
//                     return true;
//                 }
//             }
//         }

//         return false;
//     }
// }