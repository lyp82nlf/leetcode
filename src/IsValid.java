import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {
    /*
    *
    * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    * 有效字符串需满足：
    * 左括号必须用相同类型的右括号闭合。
    * 左括号必须以正确的顺序闭合。
    * 注意空字符串可被认为是有效字符串。
    *
    * */
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> symbolMap = generateSymbolMap();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (currentChar != symbolMap.get(pop)) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private Map generateSymbolMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        return map;
    }
}
