class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0, res = 0, maxCount = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            count[ch - 'A']++;
            maxCount = Math.max(maxCount, count[ch - 'A']);

            if ((r - l + 1) - maxCount > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
