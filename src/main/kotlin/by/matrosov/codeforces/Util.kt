package by.matrosov.codeforces

fun enumeration(word: String){
    val size = word.length
    val arr = IntArray(size)
    val abc = word.map { it }.groupBy { it }.keys.toCharArray()


    while (true){

        var result = ""
        for (index in arr){
            result += abc[index]
        }
        println()

        var i = size - 1
        while (arr[i] == abc.size - 1) {
            arr[i] = 0
            i--
            if (i < 0){
                println(-1)
                return
            }
        }
        arr[i]++
    }
}