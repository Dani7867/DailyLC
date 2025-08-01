class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        res.add(new ArrayList<>());
        res.get(0).add(1);

        for( int i = 1; i < numRows; i++){
            List<Integer> r = new ArrayList<>();
            List<Integer> pr = res.get(i-1);

            r.add(1);

            for(int j = 1 ;j<i;j++){
                r.add(pr.get(j-1)+pr.get(j));
            }

            r.add(1);
            res.add(r);
        }

        return res;
    }
}