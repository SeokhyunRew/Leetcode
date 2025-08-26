/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    List<Integer> seList = new ArrayList<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null) return "[]";

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            
            if(curr==null) seList.add(null);
            else{
                seList.add(curr.val);
                queue.offer(curr.left);
                queue.offer(curr.right);
            }

        }
        System.out.println(seList.toString());
        return seList.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.equals("[]")){
            return null;
        }

        String[] nodes = data.replace("[", "").replace("]", "").split(", ");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index =1;

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(!nodes[index].equals("null")){
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.left);
            }
            index ++;

            if(!nodes[index].equals("null")){
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(node.right);
            }
            index ++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));