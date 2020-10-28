import java.util.*
import kotlin.math.max

class LargestRectangleArea {
    /*
    *
    * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
    *
    * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
    *
    * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
    * 示例:
    *
    * 输入: [2,1,5,6,2,3]
    * 输出: 10
    * */
    fun largestRectangleArea(heights: IntArray): Int {
        var stack = Stack<Int>()
        //这里使用一个新数组 用于解决stack不为空 flush stack
        var tmpArray = IntArray(heights.size + 2);
        var area = 0
        for (i in 1..heights.size) {
            tmpArray[i] = heights[i - 1]
        }

        for ((index, currentHeight) in tmpArray.withIndex()) {
            while (!stack.isEmpty() && tmpArray[stack.peek()] > currentHeight) {
                var pop = stack.pop()
                //(stack.peek() + 1)这里很关键
                area = max(tmpArray[pop] * (index - (stack.peek() + 1)), area)
            }
            stack.push(index)
        }

        return area
    }

    fun largestRectangleArea1(heights: IntArray): Int {
        var res = 0;
        var stack = Stack<Int>();
        var new_heights = IntArray(heights.size + 2)
        for (i in 1..heights.size) {
            new_heights[i] = heights[i - 1]
        }
        //System.out.println(Arrays.toString(new_heights));
        for (i in 0 until new_heights.size) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                var cur = stack.pop();
                res = max(res, (i - (stack.peek() + 1)) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }

}

fun main() {
    println(LargestRectangleArea().largestRectangleArea1(intArrayOf(2, 1, 2)))
}