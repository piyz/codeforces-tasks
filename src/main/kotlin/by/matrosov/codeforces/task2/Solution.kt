package by.matrosov.codeforces.task2

fun main(){
    val inputList = mutableListOf<Int>()

    val input = readLine()!!.split(" ")
    inputList.add(input[0].toInt())
    inputList.add(input[1].toInt())
    inputList.add(input[2].toInt())

    val min = inputList.min()

    val yellow = inputList[0]
    val blue = inputList[1]
    val red = inputList[2]

    if (min == red){
        println(red - 2 + red - 1 + red)
    }else if (min == blue){
        println(blue - 1 + blue + blue + 1)
    }else{
        if (red - 1 == yellow){
            println(yellow - 1 + yellow + yellow + 1)
        }else{
            println(yellow + yellow + 1 + yellow + 2)
        }
    }
}