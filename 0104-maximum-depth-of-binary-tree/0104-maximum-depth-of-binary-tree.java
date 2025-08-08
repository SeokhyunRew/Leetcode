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
    int answer = 0;

    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        dfs(root, 1);

        return answer;
    }

    private void dfs(TreeNode curr, int dist){
        
        if(curr.left != null) dfs(curr.left, dist+1);
        else answer = (answer<dist)?dist:answer;

        if(curr.right != null) dfs(curr.right, dist+1);
        else answer = (answer<dist)?dist:answer;
    }
}