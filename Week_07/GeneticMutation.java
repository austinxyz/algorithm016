//A gene string can be represented by an 8-character long string, with choices f
//rom "A", "C", "G", "T".
//
// Suppose we need to investigate about a mutation (mutation from "start" to "en
//d"), where ONE mutation is defined as ONE single character changed in the gene s
//tring.
//
// For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
//
// Also, there is a given gene "bank", which records all the valid gene mutation
//s. A gene must be in the bank to make it a valid gene string.
//
// Now, given 3 things - start, end, bank, your task is to determine what is the
// minimum number of mutations needed to mutate from "start" to "end". If there is
// no such a mutation, return -1.
//
// Note:
//
//
// Starting point is assumed to be valid, so it might not be included in the ban
//k.
// If multiple mutations are needed, all mutations during in the sequence must b
//e valid.
// You may assume start and end string is not the same.
//
//
//
//
// Example 1:
//
//
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//return: 1
//
//
//
//
// Example 2:
//
//
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//return: 2
//
//
//
//
// Example 3:
//
//
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//return: 3
//
//
//
// 👍 470 👎 63


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    char[] chars = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {

        Set<String> words = new HashSet<String>();

        for (String w: bank) {
            words.add(w);
        }

        if (!words.contains(end)) {
            return -1;
        }

        Set<String> bSet = new HashSet<String>();
        Set<String> eSet = new HashSet<String>();

        bSet.add(start);
        eSet.add(end);

        Set<String> visited = new HashSet<String>();

        int step = 0;

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

        return -1;

    }

    boolean find(String word, Set<String>  newSet, Set<String> eSet, Set<String> visited, Set<String> words) {

        char[] wordChars = word.toCharArray();

        for (int i =0; i< word.length(); i++) {
            char orginalC = wordChars[i];

            for (char c: chars) {

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
