class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       List<Integer> l = new ArrayList<>();
for (int[] row : matrix) {
    for (int num : row) {
        l.add(num);  
    }
}
    Collections.sort(l);
return l.get(k - 1);
    }
}