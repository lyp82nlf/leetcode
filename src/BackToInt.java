public class BackToInt {
    /*
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * */
    public static void main(String[] args) {
        System.out.println(isPalindrome2(12231));
    }

    /*
     * 思路:判断回文,比如 12321  只要判断左半部分 12的回文--->21 是否和右半部分一样
     * */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int z = x;
//        可以用这种方式算长度,但是测了一下,效率比下面还要慢
//        int n = String.valueOf(x).length();
        int n = 0;
        while (x != 0) {
            n++;
            x /= 10;
        }
        boolean isEven = (n & 1) == 0;
        int m = (int) Math.pow(10, n / 2);
        int y = revert(z / m);
        x = z % (isEven ? m : (int) Math.pow(10, n / 2 + 1));
        return y == x;
    }

    public static int revert(int x) {
        if (x < 10) {
            return x;
        }
        int y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }

    /*
     * 思路:直接反转int,判断是否相等,这边其实可能存在一个溢出的问题
     * */
    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int z = x;
        int y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y == z;
    }

    /*
     * 思路:转成char数组,然后两个指针,比较
     * */
    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        char[] resultCh = String.valueOf(x).toCharArray();
        int low = 0;
        int high = resultCh.length - 1;
        while (low <= high) {
            if (resultCh[low] != resultCh[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
