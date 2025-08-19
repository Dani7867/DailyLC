class Solution {

    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();

        for (int num : nums) {
            int i = Collections.binarySearch(sub, num);

            if (i < 0) {
                i = -(i + 1); // insertion point
            }

            if (i == sub.size()) {
                sub.add(num);
            } else {
                sub.set(i, num); // replace to keep subsequence optimal
            }
        }

        return sub.size();
    }


   
    // public int lengthOfLIS(int[] nums) {
    //     return helper(nums,-1,0);
    // }

    // public int helper(int[] arr ,int pi , int ci){
    //     if(ci == arr.length) return 0;
    //     int t= 0;
    //     if(pi == -1 || arr[ci] > arr [pi]){
    //          t = 1 + helper(arr,ci,ci+1);
    //     }
    //     int nt = helper(arr,pi,ci+1);
    //     return Math.max(t,nt);
    // }
}
