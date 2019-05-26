package by.matrosov.codeforces.task1


fun main(){
    var count = 0
    val inputList = mutableListOf<Int>()
    val numberOfRequests = readLine()!!.toInt()

    while (count < numberOfRequests){
        val point = readLine()!!.toInt()

        if (point < 2) throw NumberFormatException()

        inputList.add(point)
        count++
    }

    calculateOutput(inputList)
}

fun calculateOutput(inputList: List<Int>) {

    for (input in inputList){
        var inp = input
        var count = 0
        while (true){
            val output = loop(inp)
            if (output != 0){
                if(count != 0){
                    println(output + 1)
                }else{
                    println(output)
                }
                break
            }
            inp -= if (count == 0){
                2
            }else{
                1
            }
            count++
        }
    }
}

fun loop(input: Int): Int{
    for (i in 2..7){
        if (input % i == 0){
            return input / i
        }
    }
    return 0
}