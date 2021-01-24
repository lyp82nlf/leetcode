fun Array<Any>.print() {
    this.forEach {
        print("  $it")
    }
}


fun IntArray.print() {
    this.forEach {
        print("  $it")
    }
}

fun IntArray.println() {
    this.forEach {
        print(" $it")
    }
    println(" ")
}