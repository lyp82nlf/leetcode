import java.lang.StringBuilder

class MinStack {
    var stack = ArrayList<Int>();

    fun push(x: Int) {
        stack.add(0, x);
    }

    fun pop() {
        stack.removeAt(0);
    }

    fun top(): Int {
        return stack[0]
    }

    fun getMin(): Int {
        var min: Int = Int.MAX_VALUE
        for (x in stack) {
            if (min > x) {
                min = x;
            }
        }
        return min
    }

    override fun toString(): String {
        var result = StringBuilder()
        for (element in stack) {
            result.append("$element ->")
        }
        return result.toString()
    }
}

fun main() {
    var minStack = MinStack();
    minStack.push(1)
    minStack.push(2)
    minStack.push(3)
    minStack.push(4)
    minStack.push(5)
    println(minStack.toString())
    println(minStack.getMin())
    println(minStack.top())
    minStack.pop()
    minStack.pop()
    println(minStack.toString())
    println(minStack.getMin())
}