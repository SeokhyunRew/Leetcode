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
    int answer = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        dfs(root, list);

        return answer;
    }

    private void dfs(TreeNode curr, List<Integer> list){
        if(curr==null) return;

        calculate(curr.val, list);
        list.add(curr.val);

        dfs(curr.left, list);
        dfs(curr.right, list);
    };

    private void calculate(int val, List<Integer> list){
        for(int num : list) answer = Math.min(Math.abs(val-num), answer);
    }
}