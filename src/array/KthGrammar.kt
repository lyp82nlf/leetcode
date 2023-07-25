package array

import Utils.println

class KthGrammar {
    //暴力内存超了
    /* val map = HashMap<String, String>()

     init {
         map["0"] = "01"
         map["1"] = "10"
         map["01"] = "0110"
         map["10"] = "1001"
     }

     fun kthGrammar(n: Int, k: Int): Int {
         var key = "0"
         var value = ""
         for (time in 1..n) {
             value = kthGrammar(key)
 //            map[key] = value
             key = value
         }
         return value.get(k - 1).toString().toInt()
     }

     fun kthGrammar(n: String): String {
         if (!map.containsKey(n)) {
             return kthGrammar(n.substring(0, n.length / 2)) + kthGrammar(n.substring(n.length / 2, n.length))
         }
         return map[n]!!
     }*/

    fun kthGrammar(n: Int, k: Int): Int {
        if (n == 1) {
            return 0
        }
        val parent = kthGrammar(n - 1, (k + 1) / 2)
        if (parent == 0) {
            return if (k % 2 == 0) 1 else 0
        } else {
            return if (k % 2 == 0) 0 else 1
        }
    }
}

fun main() {
    KthGrammar().kthGrammar(2, 2).println()
}