//104. Maximum Depth of Binary Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
    	//base case
        if(root == null){
            return 0;
        }

        //traverse through left and right
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        //just need to pick the deeper branch and add 1 to it
        return Math.max(left, right) + 1;
    } 
}