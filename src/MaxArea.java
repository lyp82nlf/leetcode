public class MaxArea {
    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        int i = new MaxArea().maxArea(a);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0],height[1]);
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = (right - left) * Math.min(height[left], height[right]);

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
        }
        return maxArea;
    }
}
