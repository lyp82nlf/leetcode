import jdk.nashorn.internal.runtime.regexp.joni.Matcher;

public class FibonacciSequence {
    /*
     题目描述
    大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
    n<=39
    */
    public static void main(String[] args) {
        for (int i = 0 ; i < 39 ; i ++){
            System.out.print(Fibonacci(i)+"  ");
        }
    }

    /*
    * 思路,递归
    * */
    public static int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return  1 ;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /*
    * 思路:正向计算叠加
    * */
    public int Fibonacci2(int n) {
        int preNum=1;
        int prePreNum=0;
        int result=0;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(int i=2;i<=n;i++){
            result=preNum+prePreNum;
            prePreNum=preNum;
            preNum=result;
        }
        return result;

    }

}
