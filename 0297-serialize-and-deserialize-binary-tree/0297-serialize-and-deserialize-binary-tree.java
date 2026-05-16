public class Codec {

    // SERIALIZE
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        dfsSerialize(root, sb);

        return sb.toString();
    }

    private void dfsSerialize(TreeNode node,
                              StringBuilder sb) {

        if (node == null) {

            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");

        dfsSerialize(node.left, sb);

        dfsSerialize(node.right, sb);
    }

    // DESERIALIZE
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        Queue<String> queue =
                new LinkedList<>(Arrays.asList(values));

        return dfsDeserialize(queue);
    }

    private TreeNode dfsDeserialize(
            Queue<String> queue) {

        String val = queue.poll();

        if (val.equals("null")) {
            return null;
        }

        TreeNode node =
                new TreeNode(Integer.parseInt(val));

        node.left = dfsDeserialize(queue);

        node.right = dfsDeserialize(queue);

        return node;
    }
}