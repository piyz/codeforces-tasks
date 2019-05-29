package by.matrosov.codeforces.kotlin_heroes_practice.task4

fun main() {

    val inputList = mutableListOf<String>()

    for (i in 0..1){
        inputList.add(readLine().toString())
    }

    val x = inputList[0].split(" ")[0].toInt()
    val y = inputList[0].split(" ")[1].toInt()
    val z = inputList[0].split(" ")[2].toInt()

    val g = inputList[1].split(" ")[0].toInt()
    val p = inputList[1].split(" ")[1].toInt()
    val b = inputList[1].split(" ")[2].toInt()

    if (g - x < 0){
        println("NO")
        return
    }

    if (p + g - x - y < 0){
        println("NO")
        return
    }

    if (p + g - x - y + b - z < 0){
        println("NO")
        return
    }

    println("YES")
}