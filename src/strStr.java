public class strStr {
    public static void main(String[] args) {
        System.out.println(new strStr().strStr("hello", "ll"));
        System.out.println(new strStr().strStr("aaaaa", "bba"));
        System.out.println(new strStr().strStr("mississippi", "issip"));
    }

    /*
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * */
    //用  contains + index 就没什么意思了  这个题明显问的是回溯
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == 0 || needle.length() == 0) {
            return 0;
        }
        int leftP = 0, rightP = 0;
        for (; leftP < haystack.length(); leftP++) {
            if (haystack.charAt(leftP) == needle.charAt(rightP)) {
                rightP++;
                if (rightP >= needle.length()) {
                    return leftP - rightP + 1;
                }
            } else {
                leftP -= rightP;
                rightP = 0;
            }
        }
        return -1;
    }
}
