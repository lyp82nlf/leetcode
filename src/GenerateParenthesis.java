import java.util.*;

public class GenerateParenthesis {

    /*
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * 例如，给出 n = 3，生成结果为：
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     * */

    /*
    "(((())))",
    "((()()))",
    "((())())",
    "((()))()",
    "(()(()))",
    "(()()())",
    "(()())()",
    "(())(())",
    "(())()()",
    "()((()))",
    "()(()())",
    "()(())()",
    "()()(())",
    "()()()()"]
     */


    /*
     *
     * */
    public static void main(String[] args) {
        List<String> stringList = new GenerateParenthesis().generateParenthesis(3);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
    }


    /*
     * 1.深度优先 做减法
     * 2.广度优先
     * 3.动态规划
     * */
    public List<String> generateParenthesis(int n) {
//        1
        ArrayList<String> arrayList = new ArrayList<>();
        generateParenthesis("", n, n, arrayList);
        return arrayList;
    }

    public void generateParenthesis(String str, int left, int right, ArrayList arrayList) {
        if (left == 0 && right == 0) {
            arrayList.add(str);
            return;
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            generateParenthesis(str + "(", left - 1, right, arrayList);
        }
        if (right > 0) {
            generateParenthesis(str + ")", left, right - 1, arrayList);
        }
    }
}
