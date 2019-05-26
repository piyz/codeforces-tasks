

fun main(){
    var count = 0
    val inputList = mutableListOf<String>()
    val numberOfRequests = readLine()!!.toInt()

    while (count < numberOfRequests){
        val word = readLine()!!.toString()
        inputList.add(word)
        count++
    }

    calculateOutput(inputList)
}

fun calculateOutput(inputList: List<String>){
    for (word in inputList){
        if (word.none { it != word[0] }){
            println(-1)
            continue
        }
        if (!isPalindrome(word)){
            println(word)
            continue
        }
        enumeration(word)
    }
}

fun isPalindrome(word: String): Boolean{
    if (word == word.reversed()) return true
    return false
}

fun enumeration(word: String){
    for (i in 0..word.length - 2){
        for (j in i+1 until word.length){
            val w = swap(word,i,j)
            if (!isPalindrome(w)){
                println(w)
                return
            }
        }
    }
    println(-1)
}

fun swap(word: String, i:Int, j:Int): String {
    val old = word[i]
    var w = word.replaceRange(i,i+1, word[j].toString())
    w = w.replaceRange(j,j+1, old.toString())
    return w
}


