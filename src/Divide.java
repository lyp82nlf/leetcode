public class Divide {

    /*
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * 示例 1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     * 示例 2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     * */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        boolean isSameType = true;
        float ans = 0;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            isSameType = false;
        }
        float dividendF = Math.abs(dividend);
        float divisorF = Math.abs(divisor);
        if (dividend == -2147483648) {
            dividendF = 2147483648f;
        }
        if (divisor == -2147483648) {
            divisorF = 2147483648f;
        }
        while (dividendF >= divisorF) {
            dividendF -= divisorF;
            ans++;
        }
        return (int) (ans * (isSameType ? 1 : -1));
    }

    public static void main(String[] args) {
        System.out.println(new Divide().divide(-2147483648, 1));
    }
}



