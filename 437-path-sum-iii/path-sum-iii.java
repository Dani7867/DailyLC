class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);  // base case: one way to reach sum 0
        return dfs(root, 0L, targetSum, map);
    }

    private int dfs(TreeNode node, long csum, int target, HashMap<Long, Integer> map) {
        if (node == null) return 0;

        csum += node.val;
        int count = map.getOrDefault(csum - target, 0);

        map.put(csum, map.getOrDefault(csum, 0) + 1);

        count += dfs(node.left, csum, target, map);
        count += dfs(node.right, csum, target, map);

        // backtrack
        map.put(csum, map.get(csum) - 1);
        if (map.get(csum) == 0) {
            map.remove(csum);
        }

        return count;
    }
}
