class Solution {

    public boolean isSubtree(TreeNode root,
                             TreeNode subRoot) {

        // Empty tree reached
        if (root == null) {
            return false;
        }

        // Check current subtree
        if (isSame(root, subRoot)) {
            return true;
        }

        // Search left or right
        return isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }

    // SAME TREE FUNCTION
    private boolean isSame(TreeNode p,
                           TreeNode q) {

        // Both null
        if (p == null && q == null) {
            return true;
        }

        // One null
        if (p == null || q == null) {
            return false;
        }

        // Value mismatch
        if (p.val != q.val) {
            return false;
        }

        // Compare children
        return isSame(p.left, q.left)
            && isSame(p.right, q.right);
    }
}