//Given a list accounts, each element accounts[i] is a list of strings, where th
//e first element accounts[i][0] is a name, and the rest of the elements are email
//s representing emails of the account.
//
// Now, we would like to merge these accounts. Two accounts definitely belong to
// the same person if there is some email that is common to both accounts. Note th
//at even if two accounts have the same name, they may belong to different people
//as people could have the same name. A person can have any number of accounts ini
//tially, but all of their accounts definitely have the same name.
//
// After merging the accounts, return the accounts in the following format: the
//first element of each account is the name, and the rest of the elements are emai
//ls in sorted order. The accounts themselves can be returned in any order.
//
// Example 1:
//
//Input:
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnn
//ybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Ma
//ry", "mary@mail.com"]]
//Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.
//com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//Explanation:
//The first and third John's are the same person as they have the common email "
//johnsmith@mail.com".
//The second John and Mary are different people as none of their email addresses
// are used by other accounts.
//We could return these lists in any order, for example the answer [['Mary', 'ma
//ry@mail.com'], ['John', 'johnnybravo@mail.com'],
//['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] wo
//uld still be accepted.
//
//
//
// Note:
// The length of accounts will be in the range [1, 1000].
// The length of accounts[i] will be in the range [1, 10].
// The length of accounts[i][j] will be in the range [1, 30].
// Related Topics Depth-first Search Union Find
// 👍 2137 👎 398


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class UnionFind {
        private int count = 0;
        private int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
        public int getCount() {
            return count;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        UnionFind find = new UnionFind(accounts.size());

        Map<String, Integer> emailsToId = new HashMap<String, Integer>();

        for (int i = 0; i < accounts.size(); i++) {

            List<String> account = accounts.get(i);

            String name = account.get(0);

            for (int j = 1; j < account.size(); j++) {

                String email = account.get(j);

                if (emailsToId.containsKey(email)) {
                    find.union(emailsToId.get(email), i);
                } else {
                    emailsToId.put(email, i);
                }
            }

        }

        Map<Integer, List<String>> idToEmails = new HashMap<Integer, List<String>>();

        for (String email: emailsToId.keySet()) {

            int id = emailsToId.get(email);

            id = find.find(id);

            List<String> emails = idToEmails.get(id);

            if (emails == null) {
                emails = new ArrayList<String>();
                idToEmails.put(id, emails);
            }

            emails.add(email);
        }

        List<List<String>> result = new ArrayList<List<String>>();

        for (int id: idToEmails.keySet()) {

            List<String> account = new ArrayList<String>();
            account.add(accounts.get(id).get(0));
            List<String> emails = idToEmails.get(id);
            Collections.sort(emails);

            account.addAll(emails);

            result.add(account);
        }

        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
