class Solution {

    public boolean hasPathSum(TreeNode root,
                              int targetSum) {

        // Empty tree
        if (root == null) {
            return false;
        }

        // Leaf node
        if (root.left == null &&
            root.right == null) {

            return targetSum == root.val;
        }

        // Remaining target
        int remaining = targetSum - root.val;

        // Search left or right
        return hasPathSum(root.left, remaining)
            || hasPathSum(root.right, remaining);
    }
}