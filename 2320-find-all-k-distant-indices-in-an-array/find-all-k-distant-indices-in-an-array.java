class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        boolean[] mark = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int start = Math.max(0, i - k);
                int end = Math.min(nums.length - 1, i + k);
                for (int j = start; j <= end; j++) {
                    mark[j] = true;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (mark[i]) res.add(i);
        }

        return res;
    }
}
