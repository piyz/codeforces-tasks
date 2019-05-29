package by.matrosov.codeforces.kotlin_heroes_practice.task3

fun readInt(): Int {
    val s : String? = readLine()
    return s?.toInt() ?: 0
    //return if (s==null) 0 else s.toInt()
}

fun readIntArr(): List<Int> {
    return readLine()!!.split(" ").map { it.toInt() }
}

fun min(a: Int, b: Int) : Int {
    return if(a<b) a else b
}

fun max(a: Int, b: Int) : Int {
    return if(a>b) a else b
}

fun ispal(s: String): Boolean {
    var i = 0
    var j = s.length-1
    while(i<j){
        if(s[i++] != s[j--]) return false
    }
    return true
}

fun issame(s: String): Boolean {
    for(i in 1..s.length-1){
        if(s[0]!=s[i]) return false
    }
    return true
}

fun rot(s: String): String{
    return s.substring(1) + s[0]
}

fun main() {
    val n = readInt()
    for(i in 1..n){
        var s = readLine()!!
        if(!ispal(s)){
            println(s)
        }
        else if(issame(s)){
            println(-1)
        }
        else {
            println(rot(s))
        }
    }
}