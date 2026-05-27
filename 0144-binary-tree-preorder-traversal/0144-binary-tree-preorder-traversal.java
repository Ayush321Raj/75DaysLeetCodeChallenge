class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        dfs(root, result);

        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }

        // Root
        result.add(node.val);

        // Left
        dfs(node.left, result);

        // Right
        dfs(node.right, result);
    }
}