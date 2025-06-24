class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();

        // Step 1: Collect all positions where nums[i] == key
        List<Integer> keyIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIndices.add(i);
            }
        }

        // Step 2: For each index in the array, check if it is within distance k of any key index
        for (int i = 0; i < nums.length; i++) {
            for (int j : keyIndices) {
                if (Math.abs(i - j) <= k) {
                    res.add(i);
                    break;  // Only need one such key index
                }
            }
        }

        return res;
    }
}
