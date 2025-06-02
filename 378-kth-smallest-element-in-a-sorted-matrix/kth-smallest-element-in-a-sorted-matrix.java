class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i = 0 ; i < Math.min(n,k) ; i++){
            heap.offer(new int[]{matrix[i][0],i,0});
        }
        for(int i = 0 ; i<k-1 ; i++){
            int[] smallest = heap.poll();
            int row = smallest[1] , col = smallest[2];
            if(col + 1 < n){
                 heap.offer(new int[]{matrix[row][col+1],row,col+1});
            }
        }
        return heap.poll()[0];
    }
}