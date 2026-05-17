class Solution {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);

        return diameter;
    }

    private int dfs(TreeNode node) {

        // Base case
        if (node == null) {
            return 0;
        }

        // Heights
        int left = dfs(node.left);
        int right = dfs(node.right);

        // Update diameter
        diameter = Math.max(diameter,
                            left + right);

        // Return height
        return 1 + Math.max(left, right);
    }
}