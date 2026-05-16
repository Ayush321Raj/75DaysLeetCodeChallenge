class Solution {

    public boolean isSameTree(TreeNode p,
                              TreeNode q) {

        // Both null
        if (p == null && q == null) {
            return true;
        }

        // One null
        if (p == null || q == null) {
            return false;
        }

        // Values different
        if (p.val != q.val) {
            return false;
        }

        // Compare left and right
        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}