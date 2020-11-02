//Given a 2D board and a list of words from the dictionary, find all words in th
//e board.
//
// Each word must be constructed from letters of sequentially adjacent cell, whe
//re "adjacent" cells are those horizontally or vertically neighboring. The same l
//etter cell may not be used more than once in a word.
//
//
//
// Example:
//
//
//Input:
//board = [
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//words = ["oath","pea","eat","rain"]
//
//Output: ["eat","oath"]
//
//
//
//
// Note:
//
//
// All inputs are consist of lowercase letters a-z.
// The values of words are distinct.
//
// Related Topics Backtracking Trie
// 👍 3078 👎 129


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Trie {

        private boolean isEnd;
        private Trie[] next;

        /** Initialize your data structure here. */
        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }

            Trie current = this;

            for (char c: word.toCharArray()) {
                int n = c - 'a';
                if (current.next[n] == null) {
                    current.next[n] = new Trie();
                }
                current = current.next[n];
            }
            current.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node!=null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node !=null;
        }

        private Trie searchPrefix(String word) {
            Trie node = this;
            for (char c: word.toCharArray()) {
                node = node.next[c-'a'];
                if (node == null) {
                    return null;
                }
            }

            return node;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (int i=0; i< words.length; i++) {
            trie.insert(words[i]);
        }

        Set<String> result = new HashSet<String>();

        for (int i=0; i< board.length; i++) {

            for (int j = 0; j< board[0].length; j++) {
                int[][] used = new int[board.length][board[0].length];

                find(new StringBuffer(), i, j, trie, board, used, result);
            }
        }

        return new ArrayList<String>(result);
    }

    void find(StringBuffer prefix, int i, int j, Trie trie, char[][] board, int[][] used, Set<String> result) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j] == 1) {
            return;
        }

        prefix.append(board[i][j]);
        used[i][j] = 1;

        if (!trie.startsWith(prefix.toString())) {
            used[i][j] = 0;
            prefix.deleteCharAt(prefix.length() -1);
            return;
        }

        if (trie.search(prefix.toString())) {
            result.add(prefix.toString());
        }


        find(prefix, i+1, j, trie, board, used, result);
        find(prefix, i-1, j, trie, board, used, result);
        find(prefix, i, j+1, trie, board, used, result);
        find(prefix, i, j-1, trie, board, used, result);

        used[i][j] = 0;
        prefix.deleteCharAt(prefix.length() -1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
