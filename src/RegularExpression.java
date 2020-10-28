public class RegularExpression {
    /*
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）。
     *  在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     * */
    public static void main(String[] args) {
        System.out.println("result:" + match("ab".toCharArray(), ".*c".toCharArray()));
    }


    public static boolean match(char[] str, char[] pattern) {
        return isMatch2(str, 0, str.length, pattern, 0, pattern.length);
    }

    /*
     *
     *
     * 思路:这边主要是以pattern为主,考虑一下几种情况发生,使用递归
     *
     * 考虑几种情况
     * a*
     * .*
     * aa
     * .a
     *
     *
     * */
    public static boolean match2(char[] str, int i, int strLength, char[] pattern, int j, int patternLength) {

        if ((i == strLength) && (j == patternLength)) {
            return true;
        }
        if ((i == strLength) && (j != patternLength)) {
            while (j != patternLength) {
//                考虑什么时候会false
//                aa
//                .a
//
                if ((pattern[j] != '*' && ((j + 1 >= patternLength) || pattern[j + 1] != '*'))) {
                    return false;
                }
                j++;
            }
            return true;
        }
        if ((i != strLength) && (j == patternLength)) {
            return false;
        }

        if (str[i] == pattern[j] || pattern[j] == '.') {
//            第一个相等 a*或者.*
            if ((j + 1 < patternLength) && pattern[j + 1] != '*') {
//                aa 或者 .a
                return match2(str, i + 1, strLength, pattern, j + 1, patternLength);
            }
            if ((j + 1 < patternLength) && pattern[j + 1] == '*') {
//                a* 或者.*
//                a* 就两种情况  要么 aaaaaa 要么 ''
                return match2(str, i + 1, strLength, pattern, j, patternLength) || match2(str, i, strLength, pattern, j + 2, patternLength);

            }
            if (j + 1 == patternLength) {
//                a结尾,正则表达式已经到最后
                return match2(str, i + 1, strLength, pattern, j + 1, patternLength);
            }
        } else {
//            第一个不等
            if ((j + 1 < patternLength) && pattern[j + 1] == '*') {
//                a* 或者.*
//                a* 就两种情况  要么 aaaaaa 要么 ''
                return match2(str, i, strLength, pattern, j + 2, patternLength);
            }
        }
        return false;

    }

    /*
     * 思路:这边主要是想用正向的方式去把所有的方式都解决,考虑一下所有情况
     * */
//    public static boolean match(char[] str, char[] pattern) {
//        if (str.length == 0 && pattern.length == 0) {
//            return true;
//        }
//        if (str.length != 0 && pattern.length == 0) {
//            return false;
//        }
//        if (str.length == 0 && pattern.length != 0) {
//            if (pattern.length > 1 && pattern[1] == '*') {
//                //第二个是*
//                return match("".toCharArray(), String.valueOf(pattern).substring(2).toCharArray());
//            } else {
//                return false;
//            }
//        }
////        下面的情况是 str 和pattern 长度都不为0
////        str 和pattern 都不为0
//        char p1 = pattern[0];
//        if (pattern.length > 1) {
////            pattern 长度大于1位
////            判断是否有*存在
//            char p2 = pattern[1];
//            if (p2 == '*') {
//                if (pattern.length > 2) {
////                    考虑 aaaaaaaa  和a*a*的情况
//                    if (str[0] != p1 && p1 !='.'){
//                        return match(str,String.valueOf(pattern).substring(2).toCharArray());
//                    }
//                    if (pattern[2] == p1) {
//                        int sLength = 0;
//                        int pLength = 0;
//                        int pIndex = 0;
//                        while (sLength < str.length && str[sLength] == str[0]) {
//                            sLength++;
//                        }
//                        for (int i = 0; i < pattern.length; i++) {
//                            if (pattern[i] == p1) {
//                                pLength++;
//                                pIndex ++ ;
//                            } else if (pattern[i] == '*') {
//                                pLength--;
//                                pIndex ++;
//                            } else {
//                                break;
//                            }
//                        }
//                        if (pLength <= sLength) {
//                            return match(String.valueOf(str).substring(sLength).toCharArray(),String.valueOf(pattern).substring(pIndex).toCharArray());
//                        } else {
//                            return false;
//                        }
//                    } else {
////                        这里是 aaa  和 a*b的情况
//                        return match(String.valueOf(str).substring(1).toCharArray(), pattern);
//                    }
//                } else {
//                    //                        这里是 aaa  和 a* 或 b* 或 .*的情况
//                    // pattern.length <=2
//                    if (str[0] == p1){
//                        return match(String.valueOf(str).substring(1).toCharArray(), pattern);
//                    }else {
//                        return false;
//                    }
//                }
//            } else {
//                if (p1 == '.' || p1 == str[0]) {
//                    return match(String.valueOf(str).substring(1).toCharArray(), String.valueOf(pattern).substring(1).toCharArray());
//                } else {
//                    return false;
//                }
//            }
//        } else {
////            pattern 的长度为1
//            if (p1 == '.' || p1 == str[0]) {
//                return match(String.valueOf(str).substring(1).toCharArray(), "".toCharArray());
//            } else {
//                return false;
//            }
//        }
//    }

    public static boolean isMatch2(char[] str, int i, int sLength, char[] pattern, int j, int pLength) {
        // 左边没结束,右边结束
        if (sLength != i && pLength == j) {
            return false;
        }
        //左边结束,右边结束
        if (i == sLength && j == pLength) {
            return true;
        }
        //左边结束,右边没结束
        if (i == sLength && j != pLength) {
            while (j != pLength) {
                //aa  .a  a*
                if ((pattern[j] != '*') && ((j + 1 == pLength) || (pattern[j + 1] != '*'))) {
                    return false;
                }
                j++;
            }
            return true;
        }
        //右边没到结尾
        if (j + 1 != pLength) {
            //不匹配,下一个也是*
            if (((str[i] != pattern[j]) && pattern[j] != '.') && (pattern[j + 1] != '*')) {
                return false;
            }
            // 匹配,并且下一个不是*
            // aabc
            // aa a.
            if (((str[i] == pattern[j]) || pattern[j] == '.') && (pattern[j + 1] != '*')) {
                return isMatch2(str, i + 1, sLength, pattern, j + 1, pLength);
            }
            // 不匹配,但是下一个是*
            if (((str[i] != pattern[j]) && pattern[j] != '.') && (pattern[j + 1] == '*')) {
                return isMatch2(str, i, sLength, pattern, j + 2, pLength);
            }
            // 匹配,下一个是*
            //aabc
            //a* .*
            if (((str[i] == pattern[j]) || pattern[j] == '.') && pattern[j + 1] == '*') {
                return isMatch2(str, i, sLength, pattern, j + 2, pLength) || isMatch2(str, i + 1, sLength, pattern, j, pLength);
            }
        }

        //右边是最后一个字符
        if (((str[i] == pattern[j]) || pattern[j] == '.')) {
            return isMatch2(str, i + 1, sLength, pattern, j + 1, pLength);
        }
        return false;
    }

}
