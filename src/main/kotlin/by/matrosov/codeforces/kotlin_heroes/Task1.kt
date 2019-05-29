package by.matrosov.codeforces.kotlin_heroes

fun main() {

    val a = 1
    var b: Int
    var c: Int

    val req = readLine()!!.toInt()
    repeat(req){

        val input = readLine()!!.split(" ")

        val sum1 = input[0].toInt()
        val sum2 = input[1].toInt()

        if (sum1 >= sum2){
            b = sum1 - sum2 + a
            c = sum1 - b
        }else{
            b = sum2 - sum1 + a
            c = sum2 - b
        }

        print(a)
        print(" ")
        print(b)
        print(" ")
        print(c)
        println()
    }
}