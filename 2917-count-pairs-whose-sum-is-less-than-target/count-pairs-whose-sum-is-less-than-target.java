class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int res = 0;
        nums.sort((a,b)-> a-b);
        int l = 0;
        int r = nums.size() - 1;
        while(l!=r){
            if(nums.get(l) + nums.get(r) < target){
                res += r-l;
                l++;
            }else{
                r--;
                }
        }

        return res;
        
    }
}

// int res = 0 ;
//         for(int i = 0 ; i<nums.size() ; i++){
//             for(int j = i +1 ; j < nums.size() ; j++){
//                 if(nums.get(i) + nums.get(j) < target){
//                     res ++;
//                 }
//             }
//         }
//             return res;