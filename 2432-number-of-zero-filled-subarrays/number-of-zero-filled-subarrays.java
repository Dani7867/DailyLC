class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0, s = 0;
        for (int num : nums) {
            s = (num == 0) ? s + 1 : 0;
            cnt += s;
        }
        return cnt;
    }
}