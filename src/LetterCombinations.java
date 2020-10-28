import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {
        List<String> stringList = new LetterCombinations().letterCombinations("8");
        for (String string : stringList) {
            System.out.println(string);
        }
//        for (int i = 2;i < 10;i++){
//            System.out.println(String.valueOf(new LetterCombinations().int2Char(""+i, 0)));
//        }
    }
    /*
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     *
     * */

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        letterCombinations1(digits, 0, "");
        return result;
    }


    public void letterCombinations1(String digits, int startIndex, String s) {
        if (startIndex == digits.length()) {
            result.add(s);
            return;
        }
        //获取数字对应的第一个字母
        char firstChar = int2Char(digits, startIndex);
        for (int i = 0; i < ((firstChar == 'p' || firstChar == 'w') ? 4 : 3); i++) {
            letterCombinations1(digits, startIndex + 1, s + ((char) (firstChar + i)));
        }
    }

    private char int2Char(String digits, int startIndex) {
        int char2int = digits.charAt(startIndex) - 48;
        if (char2int == 8 || char2int == 9) {
            return (char) (char2int + 96 + (char2int - 2) * 2);
        }
        return (char) (char2int + 95 + (char2int - 2) * 2);
    }
}
