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
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean reverse = false;

        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < len; i++){
                TreeNode node = q.poll();
                level.add(node.val);

                if(node.left != null) 
                    q.add(node.left);
                if(node.right != null) 
                    q.add(node.right);
            }

            if(reverse){
                Collections.reverse(level);
            }

            ls.add(level);
            reverse = !reverse;
        }

        return ls;
    }
}