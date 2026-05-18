class Solution {

    int count = 0;
    int answer = 0;

    public int kthSmallest(TreeNode root, int k) {

        inorder(root, k);

        return answer;
    }

    private void inorder(TreeNode node, int k) {

        if (node == null) {
            return;
        }

        // Left
        inorder(node.left, k);

        // Root
        count++;

        if (count == k) {
            answer = node.val;
            return;
        }

        // Right
        inorder(node.right, k);
    }
}