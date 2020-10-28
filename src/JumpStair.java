import java.util.HashSet;
import java.util.Iterator;

public class JumpStair {

    /*
     *
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *
     * */


    /*
     * 思路:跳台阶,有两种跳法,一次跳1级或者两级
     * 递归思路,考虑n的情况,跳到n有两种方式,一种是n-1跳上来,一种是n-2跳上来
     * f(n) = f(n-1)+f(n-2)
     * */
    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new int[]{1, 2, 3, 4});
        hashSet.add(new int[]{1, 2, 3, 4});
        System.out.println(hashSet.size());
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println(new int[]{1, 2, 3, 4}.hashCode());
        System.out.println(new int[]{1, 2, 3, 4}.hashCode());
    }
}

