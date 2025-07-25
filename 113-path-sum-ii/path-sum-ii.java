/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> validPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, 0, currentPath, validPaths);
        return validPaths;
    }

    public void dfs(TreeNode node, int targetSum, int sum, List<Integer> path, List<List<Integer>> result){
        if(node == null) return;
        
        path.add(node.val);
        sum += node.val;

        if(node.left == null && node.right == null){
            if(targetSum == sum){
                result.add(new ArrayList<>(path));
            }
        }else{
            dfs(node.left,targetSum,sum,path,result);
            dfs(node.right,targetSum,sum,path,result);
        }

        path.remove(path.size()-1);
    }
}