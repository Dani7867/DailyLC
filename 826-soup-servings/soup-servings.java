class Solution {
    private Double[][] cache;
    public double soupServings(int n) {
        if(n>5000) return 1.0;

        int units = (int) Math.ceil(n / 25.0); // ml -> 25ml unit
        cache = new Double[units + 1][units + 1];

        return helper(units, units);
    }

    private double helper(int sA , int sB){
        if(sA <= 0 && sB <= 0) return 0.5;
        if(sA <= 0) return 1.0;
        if(sB <= 0) return 0.0;

        if(cache[sA][sB] != null) return cache[sA][sB];

        double prob = 0.25 * (
            helper(sA - 4, sB) +
            helper(sA - 3, sB - 1) +
            helper(sA - 2, sB - 2) +
            helper(sA - 1, sB - 3)
        );
        
        cache[sA][sB] = prob;
        return prob;
    }
}