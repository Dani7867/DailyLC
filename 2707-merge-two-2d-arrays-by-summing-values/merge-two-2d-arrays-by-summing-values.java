class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> mergedMap = new TreeMap<>();

        for (int[] pair : nums1) {
         mergedMap.put(pair[0], mergedMap.getOrDefault(pair[0], 0) + pair[1]);
        }
        for (int[] pair : nums2) {
         mergedMap.put(pair[0], mergedMap.getOrDefault(pair[0], 0) + pair[1]);
        }

                int[][] result = new int[mergedMap.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : mergedMap.entrySet()) {
            result[index++] = new int[]{entry.getKey(), entry.getValue()};
        }

        return result;


    }
}