package by.matrosov.codeforces.kotlin_heroes

fun main() {

    val numberOfRequest = readLine()!!.toInt()
    val strings = Array(numberOfRequest * 2){ readLine().toString()}

    var first:String
    var second:String
    var count = 0

    repeat(numberOfRequest){j: Int ->

        first = strings[j + count]
        second = strings[j + 1 + count]

        var i = -1
        while (true){
            i++
            if (i > second.length - 1 || i > first.length - 1){
                if (first == second){
                    println("YES")
                }else{
                    println("NO")
                }
                break
            }

            if (first[i] != second[i]){
                if (first[i] == '-'){
                    if (first.length - 1 >= i + 1){
                        if (first[i+1] == '-'){
                            first = first.replaceRange(i,i+2,"+")
                            i--
                        }
                    }
                }else{
                    println("NO")
                    break
                }
            }
        }
        count++
    }
}