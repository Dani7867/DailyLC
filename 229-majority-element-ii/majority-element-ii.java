class Solution {
    public List<Integer> majorityElement(int[] nums) {
            List<Integer> list = new ArrayList<>();
            int c1 =0 ,c2=0;
            int count1 = 0 , count2 = 0;

            for(int x : nums){
                if(x==c1){
                    count1++;
                }else if(x==c2){
                    count2++;
                }else if(count1 == 0){
                    c1 = x;
                    count1 = 1;
                }else if(count2 == 0){
                    c2 = x;
                    count2 = 1;
                }else{
                    count1--;
                    count2--;
                }
            }

            count1 = count2 = 0;
            for(int n :nums){
                if(n==c1) count1++;
                else if(n==c2) count2++;
            }

            if(count1 > nums.length / 3) list.add(c1);
            if(count2 > nums.length / 3) list.add(c2);
            return list;

    }

}

    