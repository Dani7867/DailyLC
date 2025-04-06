class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k = 0;
        int[] m = new int[nums1.length+nums2.length];

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                m[k++] = nums1[i++];
            }else{
                m[k++] = nums2[j++];
            }
        }

       while(i<nums1.length) m[k++] = nums1[i++];
       while(j<nums2.length) m[k++] = nums2[j++];

       int mid = m.length / 2;
       if(m.length % 2 == 0) return (double)(m[mid - 1] + m[mid] ) / 2;

       return m[mid];
    }
}