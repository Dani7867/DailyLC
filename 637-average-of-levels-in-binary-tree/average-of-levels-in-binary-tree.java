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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root == null){return list;}

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int lvlSize = q.size();
            double lvlavg = 0;
            for(int i = 0 ; i<lvlSize ; i++){
                TreeNode curr = q.poll();
                lvlavg += curr.val;
                if(curr.left != null){q.offer(curr.left);}
                if(curr.right != null){q.offer(curr.right);}
            }
            lvlavg /= lvlSize;
            list.add(lvlavg);
        }
        return list;
    }
}