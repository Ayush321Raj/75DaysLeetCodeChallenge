class Solution {

    public int maxDepth(TreeNode root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Find left depth
        int leftDepth = maxDepth(root.left);

        // Find right depth
        int rightDepth = maxDepth(root.right);

        // Current depth
        return 1 + Math.max(leftDepth, rightDepth);
    }
}