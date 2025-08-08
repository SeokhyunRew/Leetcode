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
        dfs(root, 1);
        return answer;
    }

    private void dfs(TreeNode curr, int depth) {
        if (curr == null) return;

        answer = Math.max(answer, depth);

        dfs(curr.left, depth + 1);
        dfs(curr.right, depth + 1);
    }
}
