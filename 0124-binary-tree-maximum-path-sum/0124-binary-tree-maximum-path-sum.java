class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return maxSum;
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        // Ignore negative paths
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // Path passing through current node
        int currentPath =
                node.val + leftGain + rightGain;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // Return best single path to parent
        return node.val + Math.max(leftGain, rightGain);
    }
}