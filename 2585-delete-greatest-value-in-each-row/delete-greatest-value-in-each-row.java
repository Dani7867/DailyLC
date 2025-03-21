class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int sum = 0;

        // Step 1: Sort each row in ascending order
        for (int i = 0; i < rows; i++) {
            Arrays.sort(grid[i]);
        }

        // Step 2: Iterate column-wise from right to left
        for (int j = cols - 1; j >= 0; j--) {
            int maxVal = 0;
            for (int i = 0; i < rows; i++) {
                maxVal = Math.max(maxVal, grid[i][j]);
            }
            sum += maxVal;
        }

        return sum;
    }
}