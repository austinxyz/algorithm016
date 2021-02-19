//Given an m x n board of characters and a list of strings words, return all wor
//ds on the board.
//
// Each word must be constructed from letters of sequentially adjacent cells, wh
//ere adjacent cells are horizontally or vertically neighboring. The same letter c
//ell may not be used more than once in a word.
//
//
// Example 1:
//
//
//Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f"
//,"l","v"]], words = ["oath","pea","eat","rain"]
//Output: ["eat","oath"]
//
//
// Example 2:
//
//
//Input: board = [["a","b"],["c","d"]], words = ["abcb"]
//Output: []
//
//
//
// Constraints:
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] is a lowercase English letter.
// 1 <= words.length <= 3 * 104
// 1 <= words[i].length <= 10
// words[i] consists of lowercase English letters.
// All the strings of words are unique.
//
// Related Topics Backtracking Trie
// 👍 3418 👎 141


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Trie {

        boolean isEnd;
        Trie[] next;

        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        public void add(String word) {

            if (word == null || word.length() == 0) {
                return;
            }

            Trie current = this;
            for (char c: word.toCharArray()) {

                if (current.next[c-'a'] == null) {
                    current.next[c-'a'] = new Trie();
                }
                current = current.next[c-'a'];
            }

            current.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node !=null && node.isEnd;
        }

        public boolean startWith(String word) {
            return searchPrefix(word) != null;
        }

        public Trie searchPrefix(String word) {
            Trie current = this;

            for (char c: word.toCharArray()) {
                current = current.next[c-'a'];

                if (current == null) {
                    return null;
                }
            }

            return current;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();

        for (String word: words) {
            trie.add(word);
        }

        Set<String> result = new HashSet<String>();

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                int[][] used = new int[board.length][board[0].length];
                find (i, j, new StringBuffer(), board, used, trie, result);
            }
        }

        return new ArrayList<String>(result);

    }

    private void find(int i, int j, StringBuffer prefix, char[][] board, int[][] used, Trie trie, Set<String> result) {

        if (i >= board.length || i < 0 || j >= board[0].length || j <0 || used[i][j] == 1 ) {
            return;
        }

        prefix.append(board[i][j]);
        used[i][j] = 1;

        Trie node = trie.searchPrefix(prefix.toString());

        if (node == null) {
            prefix.deleteCharAt(prefix.length()-1);
            used[i][j] = 0;
            return;
        }

        if (node.isEnd) {
            result.add(prefix.toString());
        }

        find(i-1, j, prefix, board, used, trie, result);

        find(i+1, j, prefix, board, used, trie, result);

        find(i, j-1, prefix, board, used, trie, result);

        find(i, j+1, prefix, board, used, trie, result);

        prefix.deleteCharAt(prefix.length()-1);
        used[i][j] = 0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
