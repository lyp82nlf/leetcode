package queue

import Utils.println
import java.util.*

class AlertNames {
    val map = HashMap<String, MutableList<Int>>()
    fun alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> {
        val res = mutableSetOf<String>()

        for (i in keyName.withIndex()) {
            val name = keyName[i.index]
            val time = getTime(keyTime[i.index])
            val list = map.getOrDefault(name, mutableListOf())
            list.add(time)
            map[name] = list
        }
        for (i in map) {
            if (i.value.size < 3) {
                continue
            }
            for (time in i.value.sorted().withIndex()) {
                if (time.index < 2) {
                    continue
                }
                if (time.value - i.value.sorted()[time.index-2] <=60){
                    res.add(i.key)
                    break
                }
            }
        }
        return res.toList().sorted()
    }

    fun getTime(keyTime: String): Int {
        val split = keyTime.split(":")
        return split[0].toInt() * 60 + split[1].toInt()
    }
}

fun main() {
    AlertNames().alertNames(
        arrayOf("a", "a", "a", "a", "a", "a", "b", "b", "b", "b", "b"),
        arrayOf("23:27", "03:14", "12:57", "13:35", "13:18", "21:58", "22:39", "10:49", "19:37", "14:14", "10:41")
    ).println()
}