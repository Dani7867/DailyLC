class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // greedy choice sorting based on start values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currInt = intervals[i];
            int[] lastmerged = merged.get(merged.size() - 1);

            if (lastmerged[1] >= currInt[0]) {
                lastmerged[1] = Math.max(lastmerged[1], currInt[1]);
            } else {
                merged.add(currInt);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}