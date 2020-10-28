public class NthPower {
    /*
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     */
    public static void main(String[] args) {
        System.out.println("Power(2,1)" + Power(2, 1));
        System.out.println("Power(2,2)" + Power(2, 2));
        System.out.println("Power(2,3)" + Power(2, 3));
        System.out.println("Power(2,4)" + Power(2, 4));
        System.out.println("Power(2,-1)" + Power(2, -1));
        System.out.println("Power(2,-2)" + Power(2, -2));


    }

    /*
    * 思路:a的N次方,第一种方法是用递归直接实现,但是这样其实栈太长了
    * 这边稍微优化了一下,a的N次方 = a的n/2次方 * a的n/2次方
    * 再考虑一下奇偶的情况,就比之前的递归效率快了一半
    * */
    public static double Power(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = 1;
        if ((exponent & 1) == 0) {
            //偶数
            result = Power(base, exponent >> 1);
            result *= result;
        } else {
            result = Power(base, exponent >> 1);
            result *= result;
            result *= base;
        }
        return result;
    }
}
