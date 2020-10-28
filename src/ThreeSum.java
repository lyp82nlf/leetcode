import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
    * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    * 注意：答案中不可以包含重复的三元组。
    * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    * 满足要求的三元组集合为:
    * [[-1, 0, 1],[-1, -1, 2]]
    * */
    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, 1});
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.printf(i + "  ");
            }
            System.out.println("");
            System.out.println("*************");
        }
    }

    /*
    * 思路1:暴力法,直接算出所有的值并且移除重复 时间复杂度O(n^3)
    * 思路2:
    *   首先,这道题的难点其实在去除重复的三元组
    *   我们可以通过排序来解决这个问题
    *   思路,先排序,然后双指针
    *   双指针,如果结果小于0,则左指针+1,否则右指针-1
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        for (int i = 0; i < length; i++) {
            final int currentNum = nums[i];
            if (currentNum > 0) {
                return result;
            }
            if (i > 0 && currentNum == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                final int leftNum = nums[L];
                final int rightNum = nums[R];
                if (currentNum + leftNum + rightNum < 0) {
                    L++;
                } else if (currentNum + leftNum + rightNum > 0) {
                    R--;
                } else {
                    result.add(new ArrayList<Integer>(){{
                        add(currentNum);
                        add(leftNum);
                        add(rightNum);
                    }});
                    while (L < R && leftNum == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && rightNum == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                }
            }

        }
        return result;
    }
}
