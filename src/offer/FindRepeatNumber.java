package offer;

public class FindRepeatNumber {
    public static void main(String[] args) {
        new FindRepeatNumber().findRepeatNumber(new int[]{2, 5, 3, 1, 4});
    }

    /*
     * 找出数组中重复的数字。
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 示例 1：
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     * 限制：
     * 2 <= n <= 100000
     * */
    //1. 遍历 O(n^2)
    //2. 排序加遍历
    //3. 空间复杂度O(1)
    //4. 空间复杂度O(1) && 数组不允许改变
    public int findRepeatNumber(int[] nums) {
//        2
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
        return 0;
    }

    //2, 5, 3, 1, 4
    //2,1,3,5,4
    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int start = l;
        int end = r;
        int index = nums[start];
        while (l < r) {
            if (nums[l] <= index) {
                l++;
            } else if (nums[r] > index) {
                r--;
            } else {
                swap(nums, l, r);
            }
        }
        swap(nums, start, l);
        quickSort(nums, start, l - 1);
        quickSort(nums, l + 1, end);
    }

    private void swap(int[] nums, int l, int r) {
//        int tmp = nums[l];
//        nums[l] = nums[r];
//        nums[r] = tmp;

        nums[l] = nums[l] ^ nums[r];
        nums[r] = nums[l] ^ nums[r];
        nums[l] = nums[l] ^ nums[r];
    }


}
