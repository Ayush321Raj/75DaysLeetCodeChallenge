class Solution {

    private int preorderIndex = 0;

    private HashMap<Integer, Integer> inorderMap =
            new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder indices for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(
            int[] preorder,
            int left,
            int right
    ) {

        // No nodes
        if (left > right) {
            return null;
        }

        // Current root from preorder
        int rootValue = preorder[preorderIndex++];

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int inorderIndex = inorderMap.get(rootValue);

        // Build left subtree
        root.left = build(
                preorder,
                left,
                inorderIndex - 1
        );

        // Build right subtree
        root.right = build(
                preorder,
                inorderIndex + 1,
                right
        );

        return root;
    }
}