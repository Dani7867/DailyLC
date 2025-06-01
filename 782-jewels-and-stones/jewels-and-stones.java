
    class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        for(int i = 0; i < stones.length(); i++){
            char c = stones.charAt(i);
            if (jewels.indexOf(c) != -1){
                ans++;
            }
        }
        return ans;
    }
}
