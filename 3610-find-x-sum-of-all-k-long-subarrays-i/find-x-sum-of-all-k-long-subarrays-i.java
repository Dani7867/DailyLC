class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Frequency map for elements in the current window
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        // Compute x-sum for the first window
        result[0] = computeXSum(freqMap, x);

        // Sliding window
        for (int i = k; i < n; i++) {
            // Remove outgoing element (leftmost)
            int outgoing = nums[i - k];
            freqMap.put(outgoing, freqMap.get(outgoing) - 1);
            if (freqMap.get(outgoing) == 0) {
                freqMap.remove(outgoing);
            }

            // Add incoming element (new rightmost)
            int incoming = nums[i];
            freqMap.put(incoming, freqMap.getOrDefault(incoming, 0) + 1);

            // Compute x-sum for the current window
            result[i - k + 1] = computeXSum(freqMap, x);
        }

        return result;
    }

    private int computeXSum(Map<Integer, Integer> freqMap, int x) {
        // Convert frequency map to list of (num, freq) pairs
        List<int[]> freqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freqList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        // Sort: (1) by frequency DESC, (2) by value DESC if frequencies are equal
        freqList.sort((a, b) -> (b[1] == a[1]) ? (b[0] - a[0]) : (b[1] - a[1]));

        // Compute x-sum from the top x elements
        int xSum = 0;
        for (int i = 0; i < Math.min(x, freqList.size()); i++) {
            xSum += freqList.get(i)[0] * freqList.get(i)[1];
        }

        return xSum;
    }
}