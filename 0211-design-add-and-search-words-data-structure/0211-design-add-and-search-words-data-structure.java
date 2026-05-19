class WordDictionary {

    class TrieNode {

        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // ADD WORD
    public void addWord(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    // SEARCH
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // DFS FUNCTION
    private boolean dfs(String word,
                        int index,
                        TrieNode node) {

        // reached end
        if (index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);

        // NORMAL CHARACTER
        if (ch != '.') {

            int childIndex = ch - 'a';

            if (node.children[childIndex] == null) {
                return false;
            }

            return dfs(word,
                       index + 1,
                       node.children[childIndex]);
        }

        // DOT CASE
        else {

            // try all children
            for (TrieNode child : node.children) {

                if (child != null &&
                    dfs(word, index + 1, child)) {

                    return true;
                }
            }

            return false;
        }
    }
}