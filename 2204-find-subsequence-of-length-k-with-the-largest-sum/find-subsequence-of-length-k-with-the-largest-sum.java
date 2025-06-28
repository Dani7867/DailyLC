class Solution {
   public int[] maxSubsequence(int[] nums, int k) {
    // PriorityQueue: (value, index), ascending by value (min-heap)
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]
    );

    for (int i = 0; i < nums.length; i++) {
        pq.offer(new int[]{nums[i], i});
        if (pq.size() > k) pq.poll();  // keep only k largest
    }

    int[][] topK = new int[k][2];
    for (int i = 0; i < k; i++) topK[i] = pq.poll();

    // Sort by index to preserve original order
    Arrays.sort(topK, (a, b) -> Integer.compare(a[1], b[1]));

    int[] res = new int[k];
    for (int i = 0; i < k; i++) res[i] = topK[i][0];

    return res;
}

}