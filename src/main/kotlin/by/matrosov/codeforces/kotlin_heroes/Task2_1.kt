package by.matrosov.codeforces.kotlin_heroes


data class Number(val a: Int, val indx: Int) : Comparable<Number> {
    override fun compareTo(other: Number): Int {
        if (this.a > other.a) return 1
        if (this.a < other.a) return -1
        return 0
    }
}

fun main() {
    val list = mutableListOf<Number>()
    val req = readLine()!!.toInt()
    val ints = readLine()!!.split(" ").map{ it.toInt() }

    for (i in ints.indices){
        list.add(Number(ints[i], i))
    }

    println(list.filter { list.subList(0, it.indx).count { i -> i > it } >= 2 }
        .map { it }.count())
}