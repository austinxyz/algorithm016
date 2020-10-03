//Given two words (beginWord and endWord), and a dictionary's word list, find th
//e length of shortest transformation sequence from beginWord to endWord, such tha
//t:
//
//
// Only one letter can be changed at a time.
// Each transformed word must exist in the word list.
//
//
// Note:
//
//
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
//
//
// Example 1:
//
//
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog
//" -> "cog",
//return its length 5.
//
//
// Example 2:
//
//
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible trans
//formation.
//
//
//
//
// Related Topics Breadth-first Search
// 👍 3719 👎 1284


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> usedWords = new HashSet<String>();
        usedWords.add(beginWord);

        int level = 1;

        Queue<String> currQ = new LinkedList<String>();
        currQ.add(beginWord);

        while (!currQ.isEmpty()) {

            int size = currQ.size();

            for (int i=0; i<size; i++) {
                String word = currQ.poll();

                if (word.equals(endWord)) {
                    return level;
                }

                List<String> newWords = getNewWords(word, wordList, usedWords);

                currQ.addAll(newWords);
                usedWords.addAll(newWords);
            }

            level++;
        }

        return 0;
    }

    List<String> getNewWords(String word, List<String> wordList, Set<String> usedWords) {

        List<String> result = new ArrayList<String>();

        for (String newWord: wordList) {
            if (!usedWords.contains(newWord)) {
                if (canConvert(word, newWord)) {
                    result.add(newWord);
                }
            }
        }

        return result;

    }

    boolean canConvert(String word, String newWord) {
        if (word.length() != newWord.length()) {
            return false;
        }

        int length = word.length();

        int count = 0;

        for (int i=0; i < length; i++) {
            if (word.charAt(i) != newWord.charAt(i)) {
                count++;
            }
        }

        return count==1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
