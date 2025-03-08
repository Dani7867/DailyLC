class Solution {
    public int minimumRecolors(String blocks, int k) {
        int blackCount = 0, res = Integer.MAX_VALUE;
    
        for (int i = 0; i < blocks.length(); i++) {
            if (i - k >= 0 && blocks.charAt(i - k) == 'B') blackCount--;
            if (blocks.charAt(i) == 'B') blackCount++;
            res = Math.min(res, k - blackCount);
        }
        
        return res;
    }
}