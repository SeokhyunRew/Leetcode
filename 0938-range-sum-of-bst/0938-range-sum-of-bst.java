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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode curr, int low, int high){
        if(curr==null) return 0;

        if(curr.val>=low && curr.val<=high) return curr.val+dfs(curr.right, low, high)+dfs(curr.left, low, high);
        else if(curr.val<low) return dfs(curr.right, low, high);
        else return dfs(curr.left, low, high);
    }

}