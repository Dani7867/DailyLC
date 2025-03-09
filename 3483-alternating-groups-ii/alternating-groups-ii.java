class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int curr_count = 1, result = 0;
        
        for (int i = 0; i < n + k - 2; ++i) {
            if (colors[i % n] != colors[(i + 1) % n]) {
                curr_count++;
            } else {
                curr_count = 1;
            }
            result += (curr_count >= k) ? 1 : 0;
        }
        
        return result;
    }
}