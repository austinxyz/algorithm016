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
// 👍 3921 👎 1318


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<String>(wordList);
        if (words.size() == 0 || !words.contains(endWord)) {
            return 0;
        }

        Set<String> bSet = new HashSet<String>();
        Set<String> eSet = new HashSet<String>();

        bSet.add(beginWord);
        eSet.add(endWord);

        Set<String> visited = new HashSet<String>();

        int step = 1;

        while(!bSet.isEmpty() && !eSet.isEmpty()) {

            if (bSet.size() > eSet.size()) {
                Set<String> tmp = eSet;
                eSet = bSet;
                bSet = tmp;
            }

            Set<String> newSet = new HashSet<String>();

            for (String w: bSet) {
                visited.add(w);

                if (find(w, newSet, eSet, visited, words)) {
                    return step+1;
                }
            }

            step++;
            bSet = newSet;

        }

        return 0;

    }

    boolean find(String word, Set<String>  newSet, Set<String> eSet, Set<String> visited, Set<String> words) {

        char[] wordChars = word.toCharArray();

        for (int i =0; i< word.length(); i++) {
            char orginalC = wordChars[i];

            for (char c = 'a'; c<='z'; c++) {

                if (c != orginalC) {
                    wordChars[i] = c;

                    String newWord = String.valueOf(wordChars);

                    if (visited.contains(newWord)) {
                        continue;
                    }

                    if (eSet.contains(newWord)) {
                        return true;
                    }

                    if (words.contains(newWord)) {
                        newSet.add(newWord);
                    }
                }
            }

            wordChars[i] = orginalC;
        }

        return false;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
