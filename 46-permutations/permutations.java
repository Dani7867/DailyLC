class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> i = new ArrayList<>();
        for(int n:nums){
            i.add(n);
        }

        return permutationsList(new ArrayList<>(),i);
    }

    public static List<List<Integer>> permutationsList(List<Integer> p, List<Integer> up) {
        if (up.isEmpty()) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(p));
            return list;
        }
        int num = up.get(0);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i <= p.size(); i++) {
            List<Integer> f = new ArrayList<>(p);
            f.add(i, num); // Insert the current number at position i
            ans.addAll(permutationsList(f, up.subList(1, up.size()))); // Recursive call with the remaining elements
        }
        return ans;
    }
}