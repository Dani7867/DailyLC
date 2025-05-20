class Solution 
{
    public boolean isZeroArray(int[] nums, int[][] queries) 
    {
        
        int n = nums.length;
        int[] diff = new int[n + 1];

        
        for (int[] query : queries) 
        {
            int start = query[0], end = query[1];
            diff[start]--;
            if (end + 1 < n) 
            {
                diff[end + 1]++;
            }
        }

        
        int curr = 0;
        for (int i = 0; i < n; i++) 
        {
            curr += diff[i];
            nums[i] += curr;
        
            if (nums[i] > 0)
            {
                return false;
            } 
        }

      
        return true;
    }
}