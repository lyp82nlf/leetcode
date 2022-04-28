package Utils

fun Any.print() {
    print(this)
}

fun Any.println() {
    println(this)
}

fun IntArray.println() {
    for (index in this){
        print(index)
        print(" ")
    }
}