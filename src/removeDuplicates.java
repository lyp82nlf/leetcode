public class removeDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 0, 0, 0, 3, 3};
        int num = new removeDuplicates().removeDuplicates(nums);
        System.out.println(num);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
    }

    /*
    * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    示例 1:
    给定数组 nums = [1,1,2],
    函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
    你不需要考虑数组中超出新长度后面的元素。
    * */
    public int removeDuplicates(int[] nums) {
        //index  慢指针
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                if (i-index>1){
                    nums[index] = nums[i];
                }
            }
        }
        return ++index;
    }
}
