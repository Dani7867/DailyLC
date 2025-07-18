class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, r = matrix[0].length - 1;
        int t = 0, b = matrix.length - 1;
        List<Integer> list = new ArrayList<>();

        while (t <= b && l <= r) {
            // Left to Right
            for (int i = l; i <= r; i++) {
                list.add(matrix[t][i]);
            }
            t++;

            // Top to Bottom
            for (int i = t; i <= b; i++) {
                list.add(matrix[i][r]);
            }
            r--;

            // Right to Left
            if (t <= b) {
                for (int i = r; i >= l; i--) {
                    list.add(matrix[b][i]);
                }
                b--;
            }

            // Bottom to Top
            if (l <= r) {
                for (int i = b; i >= t; i--) {
                    list.add(matrix[i][l]);
                }
                l++;
            }
        }

        return list;
    }
}
