class Solution {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];

        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        List<String> result = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    private void dfs(char[][] board,
                     int r,
                     int c,
                     TrieNode node,
                     List<String> result) {

        // Boundary check
        if (r < 0 || c < 0 ||
            r >= board.length ||
            c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        // visited OR char not in trie
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        // Found word
        if (node.word != null) {

            result.add(node.word);

            // Avoid duplicates
            node.word = null;
        }

        // Mark visited
        board[r][c] = '#';

        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);

        // Restore
        board[r][c] = ch;
    }
}