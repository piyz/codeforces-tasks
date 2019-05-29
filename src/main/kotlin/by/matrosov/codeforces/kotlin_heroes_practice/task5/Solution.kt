package by.matrosov.codeforces.kotlin_heroes_practice.task5

fun main() {

    val inputList = mutableListOf<String>()

    for (i in 0..1){
        inputList.add(readLine().toString())
    }

    val length = inputList[0].toInt()
    val string = inputList[1]

    if (length > string.map { it }.groupBy { it }.count() || length == 1)
        println("Yes")
    else
        println("No")
}
