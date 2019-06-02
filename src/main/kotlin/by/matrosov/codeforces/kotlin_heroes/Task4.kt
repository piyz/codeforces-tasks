package by.matrosov.codeforces.kotlin_heroes

import java.util.*

fun main(){

    val size = readLine()!!.toInt()
    val list = readLine()!!.split(" ").map { it.toInt() }
    val n = list.count { it == -1 }

    val arrayOfLists = Array(n){ LinkedList<Int>() }
    val order = LinkedList<Int>((0 until n).toList())

    var iterator = order.iterator()
    for (item in list){

        if (!iterator.hasNext()) iterator = order.iterator()
        val i = iterator.next()

        if (item == -1){
            iterator.remove()
        }else{
            arrayOfLists[i].add(item)
        }
    }

    val result = arrayOfLists
        .joinToString(prefix = "$n\n", separator = "\n"){
            it.joinToString(prefix = "${it.size} ", separator = " ")
        }
    println(result)
}

