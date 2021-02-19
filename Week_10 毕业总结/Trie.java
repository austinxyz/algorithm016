//Implement a trie with insert, search, and startsWith methods.
//
// Example:
//
//
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");
//trie.search("app");     // returns true
//
//
// Note:
//
//
// You may assume that all inputs are consist of lowercase letters a-z.
// All inputs are guaranteed to be non-empty strings.
//
// Related Topics Design Trie
// 👍 4182 👎 65


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    boolean isEnd = false;
    Trie[] next = null;

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

            Trie next = current.next[c - 'a'];
            if (next == null) {
                current.next[c - 'a'] = new Trie();
            }

            current = current.next[c - 'a'];

        }

        current.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = findPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return findPrefix(prefix) != null;
    }

    private Trie findPrefix(String prefix) {

        Trie current = this;

        for (char c: prefix.toCharArray()) {

            Trie next = current.next[c - 'a'];
            if (next == null) {
                return null;
            }
            current = next;
        }

        return current;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
