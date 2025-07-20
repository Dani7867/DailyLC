class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        Set<List<Integer>> ans = new HashSet<>();

        for(int n : nums){
            freqMap.put(n,freqMap.getOrDefault(n,0)+1);
        }
        if (freqMap.getOrDefault(0, 0) >= 3){
            ans.add(Arrays.asList(0, 0, 0));
        }

        List<Integer> nv = new ArrayList<>();
        List<Integer> pv = new ArrayList<>();

        for (int x : freqMap.keySet()) {
            if (x < 0) nv.add(x);
            else if (x > 0) pv.add(x);
        }

        for (int n : nv) {
            for (int p : pv) {
                int k = -n - p;
                if (freqMap.containsKey(k)) {
                    if ((k == n || k == p) && freqMap.get(k) < 2) continue;
                    if ((k == n && k == p) && freqMap.get(k) < 3) continue;
                    List<Integer> ll = Arrays.asList(n, p, k);
                    Collections.sort(ll);
                    ans.add(ll);
                }
            }
        }
        return new ArrayList<>(ans);

    }
}