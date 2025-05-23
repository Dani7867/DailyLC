class Solution {
    public int search(int[] nums, int target) {
        int p = getPivot(nums,0,nums.length-1);
        int e = bs(nums,0,p,target);
        if(e==-1){
            e = bs(nums,p+1,nums.length-1,target);
        }
        return e;
    }

    private int getPivot(int[] arr , int l , int r){
        
        while(l<=r){
            int mid = l+(r-l)/2;
            if(mid < arr.length - 1 && arr[mid]>arr[mid+1]){
                return mid;
            }else if(mid>0 && arr[mid]<arr[mid-1]){
                return mid-1;
            }else if(arr[l] < arr[mid]){
                l = mid+1;
            }else{
                r = mid-1;
            }

        }
        return -1;
    }

    private int bs(int[] arr , int l , int r , int t){
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==t){
                return mid;
            }else if(t>arr[mid]){
                l = mid+1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }
}