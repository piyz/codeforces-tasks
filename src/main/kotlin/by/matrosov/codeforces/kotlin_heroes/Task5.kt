package by.matrosov.codeforces.kotlin_heroes

fun main() {


    /*
    val doorsAndSections = readLine()!!.split(" ").map { it.toInt() }
    val widthOfDoors = readLine()!!.split(" ").map { it.toInt() }
    val days = readLine()!!.toInt()
     */

    val timeTable = Array(6){ readLine()!!
        .substringAfter(" ")
        .split(" ")
        .map { it.toInt() }
    }

    //val arrayOfLists = Array(6){ LinkedList<Int>() }

    println(timeTable[0])
    println(timeTable[5])

    var a = timeTable[5]

    for (i in 0..a.size - 1){
        println(a[i+1] - a[i])
    }

    //val arr = arrayOf(1,6,1)


    /*
    val arrayOfLists = Array(n){ LinkedList<Int>() }
    arrayOfLists[0]

    val stack = Stack<Int>()
    stack.add(2)
    stack.add(3)
    stack.add(2)

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
        println("Yes")
    }else{
        println("No")
    }
     */
}