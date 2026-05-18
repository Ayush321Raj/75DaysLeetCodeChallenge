class Solution {

    public List<List<Integer>> levelOrder(
            TreeNode root) {

        List<List<Integer>> result =
                new ArrayList<>();

        // Empty tree
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue =
                new LinkedList<>();

        queue.offer(root);

        // BFS
        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level =
                    new ArrayList<>();

            // Process current level
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                level.add(node.val);

                // Add children
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}