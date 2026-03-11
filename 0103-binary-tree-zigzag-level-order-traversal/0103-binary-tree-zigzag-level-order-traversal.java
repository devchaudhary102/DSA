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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null){
            return ls;
        }

        q.add(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> l = new ArrayList<>();

            for(int i = 0; i < len; i++){
                TreeNode n = q.poll();

                if(leftToRight){
                    l.add(n.val);
                } else {
                    l.add(0, n.val); // reverse order
                }

                if(n.left != null){
                    q.add(n.left);
                }

                if(n.right != null){
                    q.add(n.right);
                }
            }

            leftToRight = !leftToRight;
            ls.add(l);
        }

        return ls;
    }
}