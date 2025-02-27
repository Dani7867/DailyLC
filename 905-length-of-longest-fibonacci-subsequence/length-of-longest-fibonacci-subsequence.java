import java.util.*;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        // Store indices of elements in arr
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // Iterate over pairs (arr[j], arr[i])
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int prev = arr[i] - arr[j];  // Find the previous term needed
                if (prev < arr[j] && indexMap.containsKey(prev)) {  // Check if it exists
                    int k = indexMap.get(prev);
                    int length = dp.getOrDefault(k * n + j, 2) + 1;  // Default length is 2
                    dp.put(j * n + i, length);
                    maxLen = Math.max(maxLen, length);
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0;  // If no valid sequence is found, return 0
    }
}
