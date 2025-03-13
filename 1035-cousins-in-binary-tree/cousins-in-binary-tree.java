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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);
        return level(root,xx,0) == level(root,yy,0) && !isSibling(root,xx,yy);
    }

    private TreeNode findNode(TreeNode root , int x){
        if(root == null) return null;
        if(root.val == x){
            return root;
        }

        TreeNode l =  findNode(root.left , x);
        if(l!=null){
            return l;
        }
        return findNode(root.right , x);
    }

    private int level(TreeNode root , TreeNode x , int l){
        if(root == null) return 0;
        if(root == x){
            return l ;
        }
        int l1 = level(root.left,x,l+1);
        if(l1!=0) return l1;
        return level(root.right,x,l+1);

    }

    private boolean isSibling(TreeNode root ,TreeNode x , TreeNode y){
        if(root == null) return false;

        return (root.left == x && root.right == y) || (root.left == y && root.right == x) || isSibling(root.left , x ,  y) || isSibling(root.right , x ,  y);
    }
}