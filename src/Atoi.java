import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atoi {
    /*
    * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
    *
    * */
    public static void main(String[] args) {
        System.out.println(myAtoi(""));
    }

    /*
     * 思路:用正则找出匹配的串,然后捕获异常,解决溢出问题
     * */
    public static int myAtoi(String str) {
        str = str.trim();
        Pattern pattern = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher matcher = pattern.matcher(str);
        int value = 0;
        if (matcher.find()) {
            try {
//                避免溢出
                value = Integer.parseInt(str.substring(matcher.start(), matcher.end()));
            } catch (NumberFormatException e) {
                value = str.charAt(matcher.start()) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return value;
    }

    /*
     * 思路:这个解决方案和上面没什么区别,就是解决溢出问题的方式不一样
     * */
    public static int myAtoi1(String str) {
        str = str.trim();
        Pattern pattern = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher matcher = pattern.matcher(str);
        int value = 0;
        boolean negative = false;
        int max_expect_result = Integer.MAX_VALUE / 10;
        int max_remainder_result = Integer.MAX_VALUE % 10;
        int min_expect_result = Integer.MIN_VALUE / 10;
        int min_remainder_result = Integer.MIN_VALUE % 10;
        if (matcher.find()) {
            for (int i = matcher.start(); i < matcher.end(); i++) {
                if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                    negative = str.charAt(i) == '-' ? true : false;
                    continue;
                }
                int j = Integer.parseInt(str.substring(i, i + 1));
                if (negative) {
                    if (value > min_expect_result || (value == min_expect_result && -j >= min_remainder_result)) {
                        value = value * 10 + -j;
                    } else {
                        value = Integer.MIN_VALUE;
                        break;
                    }
                } else {
                    if (value < max_expect_result || (value == max_expect_result && j <= max_remainder_result)) {
                        value = value * 10 + j;
                    } else {
                        value = Integer.MAX_VALUE;
                        break;
                    }
                }
            }
        }
        return value;
    }

}
