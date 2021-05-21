package dynamic

import java.util.*

/**
 * 692. 前K个高频单词
 */
class TopKFrequent {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val rateMap = mutableMapOf<String, Int>()
        for (word in words) {
            rateMap[word] = rateMap.getOrDefault(word, 0) + 1
        }
        val queue = PriorityQueue<Word>(k) { t, t2 ->
            if (t.rate == t2.rate) {
                t2.word.compareTo(t.word)
            } else {
                t.rate - t2.rate
            }
        }
        rateMap.forEach { (s, i) ->
            queue.offer(Word(s, i))
            if (queue.size > k) {
                queue.poll()
            }
        }
        val res = mutableListOf<String>()
        while (queue.isNotEmpty()) {
            res.add(queue.poll().word)
        }
        res.reverse()
        return res
    }
}

fun main() {
    print(
        TopKFrequent().topKFrequent(
            arrayOf("a","aa","aaa"),
            1
        )
    )
}

data class Word(val word: String, val rate: Int)