package printer

import Utils.println
import kotlin.math.max

class MyCircularDeque(k: Int) {
    val queue = ArrayList<Int>()
    val maxSize = k
    fun insertFront(value: Int): Boolean {
        if (queue.size == maxSize) {
            return false
        }
        queue.add(0,value)
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (queue.size == maxSize) {
            return false
        }
        queue.add(value)
        return true
    }

    fun deleteFront(): Boolean {
        if (queue.isEmpty()){
            return false
        }
        queue.removeAt(0)
        return true
    }

    fun deleteLast(): Boolean {
        if (queue.isEmpty()){
            return false
        }
        queue.removeAt(queue.size - 1)
        return true
    }

    fun getFront(): Int {
        if (queue.isEmpty()){
            return -1
        }
        return queue[0]
    }

    fun getRear(): Int {
        if (queue.isEmpty()){
            return -1
        }
        return queue.last()
    }

    fun isEmpty(): Boolean {
        return queue.isEmpty()
    }

    fun isFull(): Boolean {
        return queue.size == maxSize
    }
}
fun main() {
    val queue = MyCircularDeque(3)
    queue.insertFront(8).println()
    queue.insertLast(8).println()
    queue.insertLast(2).println()
    queue.getFront().println()
    queue.deleteLast().println()
    queue.getRear().println()
    queue.insertFront(9).println()
    queue.deleteFront().println()
    queue.getRear().println()
    queue.insertLast(2).println()
    queue.isFull().println()

}