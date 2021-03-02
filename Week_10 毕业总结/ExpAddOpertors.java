//Given a string that contains only digits 0-9 and a target value, return all po
//ssibilities to add binary operators (not unary) +, -, or * between the digits so
// they evaluate to the target value.
//
// Example 1:
//
//
//Input: num = "123", target = 6
//Output: ["1+2+3", "1*2*3"]
//
//
// Example 2:
//
//
//Input: num = "232", target = 8
//Output: ["2*3+2", "2+3*2"]
//
// Example 3:
//
//
//Input: num = "105", target = 5
//Output: ["1*0+5","10-5"]
//
// Example 4:
//
//
//Input: num = "00", target = 0
//Output: ["0+0", "0-0", "0*0"]
//
//
// Example 5:
//
//
//Input: num = "3456237490", target = 9191
//Output: []
//
//
//
// Constraints:
//
//
// 0 <= num.length <= 10
// num only contain digits.
//
// Related Topics Divide and Conquer
// 👍 1582 👎 266


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> addOperators(String num, int target) {

        return dealResult(num, Long.parseLong(String.valueOf(target)));

    }

    private List<String> dealResult(String num, long target) {

        List<String> result = new ArrayList<String>();

        if (num == null || num.length() == 0) {
            return result;
        }

        int length = 1;
        if (num.charAt(0) =='0') {
            length = 1;
        } else {
            length = num.length();
        }


        for (int i=1; i<=length; i++) {
            long x = Long.parseLong(num.substring(0, i));

            if (i == num.length()) {
                if (x == target) {
                    result.add(num);
                }

            } else {
                result.addAll(dealMultiple(x, String.valueOf(x), num.substring(i), target));
                result.addAll(addResult(dealResult(num.substring(i), target-x), String.valueOf(x), '+'));
                result.addAll(addResult(dealResult(num.substring(i), x-target), String.valueOf(x), '-'));

            }
        }

        return result;

    }

    private List<String> dealMultiple(long x, String prefix, String num, long target) {

        List<String> result = new ArrayList<String>();

        int length = 1;
        if (num.charAt(0) =='0') {
            length = 1;
        } else {
            length = num.length();
        }

        for (int i=1; i<=length; i++) {

            long y = Long.parseLong(num.substring(0, i));
            StringBuffer sb = new StringBuffer().append(prefix).append('*').append(y);

            if (i == num.length()) {
                if (x*y == target) {
                    result.add(sb.toString());
                }
            } else {
                result.addAll(dealMultiple(x*y, sb.toString(), num.substring(i), target));
                result.addAll(addResult(dealResult(num.substring(i), target-x*y), sb.toString(), '+' ));
                result.addAll(addResult(dealResult(num.substring(i), x*y-target), sb.toString(), '-'));

            }
        }

        return result;
    }

    private List<String> addResult(List<String> res, String prefix, char op) {

        List<String> result = new ArrayList<String>();

        for (String re: res) {
            if (op == '-') {
                re = reverse(re);
            }

            StringBuffer sb = new StringBuffer().append(prefix).append(op).append(re);
            result.add(sb.toString());
        }

        return result;
    }

    private String reverse(String re) {

        StringBuffer sb = new StringBuffer();

        for (char c : re.toCharArray()) {

            if (c == '+') {
                sb.append('-');
            } else if (c =='-') {
                sb.append('+');
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }


}
//leetcode submit region end(Prohibit modification and deletion)
