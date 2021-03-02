//Given a string of numbers and operators, return all possible results from comp
//uting all the different possible ways to group numbers and operators. The valid
//operators are +, - and *.
//
// Example 1:
//
//
//Input: "2-1-1"
//Output: [0, 2]
//Explanation:
//((2-1)-1) = 0
//(2-(1-1)) = 2
//
// Example 2:
//
//
//Input: "2*3-4*5"
//Output: [-34, -14, -10, -10, 10]
//Explanation:
//(2*(3-(4*5))) = -34
//((2*3)-(4*5)) = -14
//((2*(3-4))*5) = -10
//(2*((3-4)*5)) = -10
//(((2*3)-4)*5) = 10
// Related Topics Divide and Conquer
// 👍 2073 👎 108


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> numbers = new ArrayList<Integer>();
        List<Character> operators = new ArrayList<Character>();

        parseInput(input, numbers, operators);

        return getValues(numbers, operators, 0, operators.size());
    }

    private List<Integer> getResult(List<Integer> numbers, List<Character> operators, int split, int start, int end) {

        char op = operators.get(split);

        List<Integer> result = new ArrayList<Integer>();

        for (int x: getValues(numbers, operators, start, split)) {
            for (int y: getValues(numbers, operators, split+1, end)) {
                result.add(operate(x, y, op));
            }
        }

        return result;
    }

    private List<Integer> getValues(List<Integer> numbers, List<Character> operators, int start, int end) {

        List<Integer> result = new ArrayList<Integer>();

        if (start == end) {
            result.add(numbers.get(start));
            return result;
        }

        for (int i=start; i<end; i++) {
            result.addAll(getResult(numbers, operators, i, start, end));
        }

        return result;
    }

    private int operate(int x, int y, char op) {

        if (op == '+') {
            return x+y;
        } else if (op == '-') {
            return x-y;
        } else if (op == '*') {
            return x*y;
        }

        return 0;

    }

    private void parseInput(String input, List<Integer> numbers, List<Character> operators) {

        StringBuffer number = new StringBuffer();

        for (char c: input.toCharArray()) {

            if (c == '+' || c =='-' || c =='*') {
                numbers.add(Integer.valueOf(number.toString()));
                operators.add(c);
                number = new StringBuffer();
            } else {
                number.append(c);
            }

        }

        numbers.add(Integer.valueOf(number.toString()));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
