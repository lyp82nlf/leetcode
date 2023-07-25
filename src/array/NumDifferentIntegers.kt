package array

import java.math.BigDecimal

class NumDifferentIntegers {
    fun numDifferentIntegers(word: String): Int {
        val split = word.replace(Regex("[^0-9]"), " ").split(" ")
        val set = HashSet<BigDecimal>()
        for (i in split) {
            if (i.trim() == "") {
                continue
            }
            set.add(i.trim().toBigDecimal())
        }
        return set.size
    }
}

fun main() {
    NumDifferentIntegers().numDifferentIntegers("2393706880236110407059624696967828762752651982730115221690437821508229419410771541532394006597463715513741725852432559057224478815116557380260390432211227579663571046845842281704281749571110076974264971989893607137140456254346955633455446057823738757323149856858154529105301197388177242583658641529908583934918768953462557716")
}