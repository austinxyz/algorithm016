//Design a data structure that supports adding new words and finding if a string
// matches any previously added string.
//
// Implement the WordDictionary class:
//
//
// WordDictionary() Initializes the object.
// void addWord(word) Adds word to the data structure, it can be matched later.
//
// bool search(word) Returns true if there is any string in the data structure t
//hat matches word or false otherwise. word may contain dots '.' where dots can be
// matched with any letter.
//
//
//
// Example:
//
//
//Input
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//Output
//[null,null,null,null,false,true,true,true]
//
//Explanation
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
//
//
//
// Constraints:
//
//
// 1 <= word.length <= 500
// word in addWord consists lower-case English letters.
// word in search consist of '.' or lower-case English letters.
// At most 50000 calls will be made to addWord and search.
//
// Related Topics Backtracking Depth-first Search Design Trie
// 👍 2732 👎 120


//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {

    boolean isEnd = false;
    WordDictionary[] next = null;

    /** Initialize your data structure here. */
    public WordDictionary() {
        isEnd = false;
        next = new WordDictionary[26];
    }

    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        WordDictionary current = this;

        for (char c: word.toCharArray()) {

            WordDictionary next = current.next[c - 'a'];
            if (next == null) {
                current.next[c - 'a'] = new WordDictionary();
            }

            current = current.next[c - 'a'];

        }

        current.isEnd = true;
    }

    public boolean search(String word) {

        char c = word.charAt(0);

        if (word.length() == 1) {
            if (c == '.') {
                for (int i=0; i < 26; i++) {
                    if (next[i] !=null && next[i].isEnd) {
                        return true;
                    }
                }
                return false;
            } else {
                return next[c-'a'] !=null && next[c-'a'].isEnd;
            }
        }

        if (c == '.') {
            for (int i=0; i < 26; i++) {
                if (next[i] !=null) {
                    boolean find = next[i].search(word.substring(1));
                    if (find) {
                        return true;
                    }
                }
            }
        } else {
            if (next[c - 'a'] !=null) {
                return next[c - 'a'].search(word.substring(1));
            }
        }

        return false;

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
