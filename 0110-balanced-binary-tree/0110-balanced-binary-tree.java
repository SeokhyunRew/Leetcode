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
        
        int answer = dfs(root);

        return (answer==-1)?false:true;
    }

    private int dfs(TreeNode curr){
        if(curr==null) return 0;

        int left = dfs(curr.left);
        int right = dfs(curr.right);

        if(Math.abs(left-right)>1) return -1;

        if(left==-1||right==-1) return -1;

        return Math.max(left, right)+1;
    }
}