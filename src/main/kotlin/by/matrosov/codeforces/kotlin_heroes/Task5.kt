package by.matrosov.codeforces.kotlin_heroes

import java.util.*

fun main() {

    val doorsAndSections = readLine()!!.split(" ").map { it.toInt() }
    val widthOfDoors = readLine()!!.split(" ").map { it.toInt() }
    val days = readLine()!!.toInt()
    val timeTable = Array(days){ readLine()!!
        .substringAfter(" ")
        .split(" ")
        .map { it.toInt() }
    }

    val stack = Stack<Int>()
    for (i in widthOfDoors.indices){
        stack.add(widthOfDoors[i])
    }

    val arrayOfLists = Array(days){ LinkedList<Int>() }
    val list = LinkedList<Int>()


    for (j in timeTable.indices){

        val size = timeTable[j].size
        for (i in 0..size){

            var next = doorsAndSections[1]
            var prev = 1

            if (i != size){
                next = timeTable[j][i]
            }

            if (i-1 >= 0){
                prev = timeTable[j][i-1]
            }

            if (i != 0 && i != size){
                next--
            }

            val element = next - prev
            if (element != 0) list.add(element)
        }

        arrayOfLists.set(j, list)
        list.clear()
    }

    //val arr = arrayOf(1,6,1)

    println(arrayOfLists.size)
    println(arrayOfLists[0])
    println(arrayOfLists[1])
    println(arrayOfLists[2])
    for (i in arrayOfLists.indices){

        val arr = arrayOfLists[i]
        for (item in arr){
            var sum = 0
            label@ while (true){
                if (stack.peek() + sum <= item){
                    sum += stack.pop()
                    if (stack.isEmpty()){
                        println("YES")
                        return
                    }
                }else{
                    break@label
                }
            }
        }


        if (stack.isEmpty()){
            println("YES")
        }else{
            println("NO")
        }
    }
}