package by.matrosov.codeforces.kotlin_heroes_practice.task6

data class Section(val min: Int, var indexes: Set<Int>){
    var max: Int? = null

    constructor(min: Int, max: Int, indexes: Set<Int>) : this(min, indexes){
        this.max = max
    }

    override fun toString(): String {
        if (max == null){
            return "Section(min=$min, indexes=$indexes)"
        }
        return "Section(min=$min, max=$max, indexes=$indexes)"
    }
}

fun main() {
    val list = mutableListOf<Section>()

    for (i in 0..1){

        val string = readLine()!!.split(" ")
        val min = string[0].toInt()
        val max = string[1].toInt()

        if (min == max) list.add(Section(min, setOf(i)))
        else list.add(Section(min, max, setOf(i)))
    }

    println(list)


    /*

    for (i in 0..list.size - 2){
        for (j in i+1 until list.size){

        }
    }
     */

    // list.add(Section(5,5, setOf(0)))
    //    list.add(Section(2,3, setOf(1)))

    /*
    list.add(Section(3,5, setOf(0)))
    list.add(Section(2,3, setOf(1)))
    list.add(Section(2,3, setOf(2)))

    list.add(Section(3,3, setOf(0)))
    list.add(Section(4,4, setOf(1)))
    list.add(Section(5,5, setOf(2)))

    list.add(Section(3,3, setOf(0)))
    list.add(Section(4,4, setOf(1)))
    list.add(Section(5,5, setOf(2)))
    list.add(Section(2,3, setOf(3)))
    list.add(Section(1,2, setOf(4)))
     */

    //isIntersected(Section(1,2),Section(3,4)) //false
    //    isIntersected(Section(-2,-1),Section(1,2)) //false
    //    isIntersected(Section(1,4),Section(3,5)) //true
    //    isIntersected(Section(1,4),Section(1,4)) //true
    //    isIntersected(Section(1,4),Section(1,6)) //true
    //    isIntersected(Section(1,4),Section(-10,1)) //true
    //    isIntersected(Section(1,10),Section(2,3)) //true
    //    isIntersected(Section(1,10),Section(0,30)) //true
}

/*
fun isIntersected(s1:Section, s2:Section):Boolean{
    if (s1.max < s2.min || s1.min > s2.max){
        return false
    }
    return true
}
 */

fun isIntersected(s1: Section, s2: Section){

    if (s1.max == null && s2.max == null){
        if (s1.min == s2.min){
            //they are equals
        }else{
            //not equals
        }
    }else if (s1.max == null){
        if (s1.min <= s2.max!! && s1.min >= s2.min){
            //s1 into s2
        }else{
            //not equals
        }
    }else if (s2.max == null){
        if (s2.min <= s1.max!! && s2.min >= s1.min){
            //s2 into s1
        }else{
            //not equals
        }
    }else{
        if (s1.max!! < s2.min || s1.min > s2.max!!){
            //intersect
        }else{
            //non inter
        }
    }
}