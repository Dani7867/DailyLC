class Solution {
    public int rob(int[] nums) {
        int in = nums[0];
        int ex = 0;

        for(int i = 1 ; i<nums.length;i++){
            int nin = ex + nums[i];
            int nex = Math.max(ex,in);

            in = nin;
            ex = nex;
        }

        return Math.max(in,ex);       
    }

    // tle
    // private int robR(int[] n , int i){
    //     if (i>=n.length) return 0;

    //     int in = n[i] + robR(n,i+2);
    //     int ex = robR(n,i+1);

    //     return Math.max(in,ex);
    // }

    //  int[] in = new int[nums.length];
    //     int[] ex = new int[nums.length];

    //     ex[0] = 0;
    //     in[0] = nums[0];

    //     for(int i = 1 ; i < in.length ; i++){
    //         in[i] = ex[i-1] + nums[i];
    //         ex[i] = Math.max(in[i-1],ex[i-1]);
    //     }

    //     return Math.max(in[nums.length-1] , ex[nums.length - 1]);
}