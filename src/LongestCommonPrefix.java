public class LongestCommonPrefix {
    /*
     *
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

     *
     *
     * */

    public static void main(String[] args) {
        String s = new LongestCommonPrefix().longestCommonPrefix(new String[]{"aa", "a"});
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int commonLength = 0;
        while (commonLength < strs[0].length()) {
            char currentChar = strs[0].charAt(commonLength);
            for (int i = 0; i < strs.length; i++) {
                if (commonLength == strs[i].length()) {
                    return strs[0].substring(0, commonLength);
                }
                if (strs[i].charAt(commonLength) == currentChar) {
                    continue;
                } else {
                    if (commonLength < 0) {
                        return "";
                    } else {
                        return strs[0].substring(0, commonLength);
                    }
                }
            }
            commonLength++;
        }

        if (commonLength < 0) {
            return "";
        } else {
            return strs[0].substring(0, commonLength);
        }
    }
}
