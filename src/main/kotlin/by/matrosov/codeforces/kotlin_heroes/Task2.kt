package by.matrosov.codeforces.kotlin_heroes

import kotlin.math.max

fun main() {
    readLine()!!.toInt()

    val list = readLine()!!.split(" ").map { it.toInt() }

    var firstMax = 0
    var secondMax = 0
    var maxOfTwo: Int
    var count = 0

    for (i in list.indices){
        if (firstMax <= list[i] && secondMax <= list[i]){
            maxOfTwo = max(firstMax, secondMax)
            firstMax = list[i]
            secondMax = maxOfTwo
        }else if (firstMax <= list[i]){
            firstMax = list[i]
        }else if (secondMax <= list[i]){
            secondMax = list[i]
        }else{
            count++
        }
    }
    println(count)
}