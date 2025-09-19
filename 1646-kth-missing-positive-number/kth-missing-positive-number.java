class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // this many numbers are missing before arr[mid]
            int missingCount = arr[mid] - (mid + 1);

            if (missingCount < k) {
                // The k-th missing number is to the right of mid
                left = mid + 1;
            } else {
                // The k-th missing number is at or to the left of mid
                right = mid - 1;
            }
        }
         return left + k;
    }
}

        // When the loop ends, 'left' is the index where the k-th missing
        // number would be inserted to maintain the count.
        // The value of the k-th missing number is k + left.
        // For example, if arr=[10, 20] and k=5, the missing are 1,2,3,4,5.
        // The loop ends with left=0. Answer = 5 + 0 = 5.
        // If arr=[2,3] and k=1, the missing is 1.
        // The loop ends with left=0. Answer = 1 + 0 = 1.