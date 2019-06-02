package by.matrosov.codeforces.kotlin_heroes

fun main() {
    val listSize = readLine()!!.toInt()
    var list = readLine()!!.split(" ").map { it.toInt() }
    val n = list.stream().filter { it == -1 }.count().toInt()

    println(n)
    if (n == listSize){
        for (i in 0 until n){
            println(0)
        }
        return
    }

    var i = 0
    while (true){
        if (list[i] == -1 || list[i] == 0){
            list = list.subList(0,i+n) + 0 + list.subList(i+n, list.size)
        }
        i++

        if (i + n == list.size) break
    }


    var j = 0
    repeat(n){

        val result = mutableListOf<Int>()
        label@ while (true){
            if (list[j + it] == -1) break@label
            if (list[j + it] == 0) continue@label
            result.add(list[j + it])
            j += n
        }
        j = 0

        print(result.size)
        print(" ")
        for (k in result.indices){
            print(result[k])
            print(" ")
        }
        println()
    }
}