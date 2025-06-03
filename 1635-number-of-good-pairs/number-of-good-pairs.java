class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq=new int[101];
        int sum=0;
            for(int i:nums){
                sum+=freq[i];
                freq[i]++;
            }
            return sum;
        }
    
}