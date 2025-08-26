class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxd = 0;
        int area = 0;
        for(int[] r : dimensions){
            int l = r[0];
            int w = r[1];
            double diagonal = Math.sqrt((l*l)+(w*w));
            if(maxd < diagonal){
                area = l*w;
                maxd = diagonal;
            }else if(maxd == diagonal){
                area = Math.max(area,l*w);
            }
        }
        return area;
    }
}