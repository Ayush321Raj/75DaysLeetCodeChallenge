class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p,
                                         TreeNode q) {

        while (root != null) {

            // Go left
            if (p.val < root.val &&
                q.val < root.val) {

                root = root.left;
            }

            // Go right
            else if (p.val > root.val &&
                     q.val > root.val) {

                root = root.right;
            }

            // Split point found
            else {
                return root;
            }
        }

        return null;
    }
}