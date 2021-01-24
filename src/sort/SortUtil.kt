package sort

import print
import println
import kotlin.math.log
import kotlin.random.Random

class SortUtil {
    var hasChange = true
    fun bubbleSort(array: IntArray): IntArray {
        for (i in array.indices) {
            if (!hasChange) {
                break
            }
//            hasChange = false
            for (j in 0 until array.size - i - 1) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1)
                    hasChange = true
                }
            }
        }
        return array
    }

    fun insertSort(array: IntArray): IntArray {
        for (i in array.indices) {
            for (j in i downTo 0) {
                if (j > 0 && array[j] < array[j - 1]) {
                    swap(array, j, j - 1)
                } else {
                    break
                }
            }
        }
        return array
    }

    fun mergeSort(array: IntArray): IntArray {
        mergeSort(array, 0, array.size - 1)
        return array
    }

    fun mergeSort(array: IntArray, left: Int, right: Int) {
        if (left >= right) {
            return
        }
        val mid = left + (right - left) / 2
        mergeSort(array, left, mid)
        mergeSort(array, mid + 1, right)
        merge(array, left, mid, right)
    }

    fun merge(array: IntArray, left: Int, mid: Int, right: Int) {
        val copy = array.clone()
        var k = left
        var l = left
        var m = mid + 1
        while (k <= right) {
            when {
                l > mid -> {
                    array[k] = copy[m]
                    m++
                }
                m > right -> {
                    array[k] = copy[l]
                    l++
                }
                copy[l] <= copy[m] -> {
                    array[k] = copy[l]
                    l++
                }
                copy[m] < copy[l] -> {
                    array[k] = copy[m]
                    m++
                }
            }
            k++
        }
    }

    fun quickSort(array: IntArray): IntArray {
        quickSort(array, 0, array.size - 1)
        return array
    }

    //1, 3, 125, 21, 41, 124, 512, 13, 414
    private fun quickSort(array: IntArray, left: Int, right: Int) {
        if (left >= right) {
            return
        }
        val base = array[left]
        var l = left
        var r = right
        while (l < r) {
            when {
                array[l] > base && array[r] <= base -> {
                    swap(array, l, r)
                }
                array[r] > base -> {
                    r--
                }
                array[l] <= base -> {
                    l++
                }
            }
        }
        swap(array, left, l)
        println("left: $left right:$right l:$l")
        quickSort(array, left, l - 1)
        quickSort(array, l+1, right)
    }

    private fun swap(array: IntArray, j: Int, i: Int) {
        if (j == i) {
            return
        }
        array[j] = array[j].xor(array[i])
        array[i] = array[j].xor(array[i])
        array[j] = array[j].xor(array[i])
    }
}

fun main() {
    SortUtil().bubbleSort(intArrayOf(1, 3, 125, 21, 41, 124, 512, 13, 414)).println()
    SortUtil().insertSort(intArrayOf(1, 3, 125, 21, 41, 124, 512, 13, 414)).println()
    SortUtil().mergeSort(intArrayOf(1, 3, 125, 21, 41, 124, 512, 13, 414)).println()
    SortUtil().quickSort(intArrayOf(3,3,4,3,3,3)).println()
    val randomArray = IntArray(20000)
    for (i in 0 until 20000) {
        randomArray[i] = Random.nextInt(20000)
    }
    val tmp = System.currentTimeMillis()
    SortUtil().bubbleSort(randomArray)
    print("\ncost time: ${System.currentTimeMillis() - tmp}")
}