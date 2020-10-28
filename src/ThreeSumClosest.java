import java.util.Arrays;

public class ThreeSumClosest {
    /*
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
     * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     * */

    public static void main(String[] args) {
        int res = new ThreeSumClosest().threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82);
        System.out.println(res + "");
    }

    /*
    *
    * 思路1:暴力法,直接循环得到所有的结果,算出最接近的,时间复杂度 O(n^3)
    * 思路2:
    *   排序+双指针
    *   我们可以先排序,然后左右指针,如果结果比target小,左指针+1 else 有指针-1 每次记录值,如果有更近的值,就更新结果
    *   排序时间复杂度 O(nlog(n))
    *   双指针 事件复杂度 O(n^2)
    *   总共事件复杂度 O(n^2)
    * */
    public int threeSumClosest(int[] nums, int target) {
//        如果num长度为3
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int length = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < length; i++) {
            int R = length - 1;
            int L = i + 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum < target) {
                    L++;
                } else if (sum > target) {
                    R--;
                } else {
                    return sum;
                }
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
            }

        }

        return ans;
    }
}
