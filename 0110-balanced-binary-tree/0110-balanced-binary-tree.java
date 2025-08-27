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
    public boolean isBalanced(TreeNode root) {
        
        int answer = dfs(root, 0);

        return (answer==-1)?false:true;
    }

    private int dfs(TreeNode curr, int height){
        if(curr==null) return height;

        int left = dfs(curr.left, height+1);
        int right = dfs(curr.right, height+1);

        if(Math.abs(left-right)>1) return -1;

        return Math.max(left, right);
    }
}