package by.matrosov.codeforces.task6

data class Interval(val left: Int, val right: Int, var indexes: Set<Int>): Comparable<Interval>{
    override fun compareTo(other: Interval): Int {
        if (this == other) return 0
        return 1
    }
}

fun check(i1: Interval, i2: Interval): Interval?{

    if (i1.compareTo(i2) == 0){
        return Interval(i1.left, i1.right, i1.indexes.plus(i2.indexes))
    }

    var i = contains(i1,i2)
    if (i != null){
        return i
    }
    i = contains(i2, i1)
    if (i != null){
        return i
    }

    i = cross(i1, i2)
    if (i != null){
        return i
    }
    i = cross(i2, i1)
    if (i != null){
        return i
    }

    i = touch(i1, i2)
    if (i != null){
        return i
    }

    i = touch(i2, i1)
    if (i != null){
        return i
    }

    return null
}

fun main() {


    val a = Interval(3,5, setOf(0))
    val b = Interval(2,3, setOf(1))
    val c = Interval(2,3, setOf(2))
    val d = Interval(0,6, setOf(3))
    val e = Interval(0,3, setOf(4))
    val f = Interval(4,4, setOf(5))
    val g = Interval(5,10, setOf(6))

    //val list = mutableListOf(r,t,y)
    val list = mutableListOf(a,b,c,d,e,f,g)
    val count = list.size - 1

    var i = -1
    var j: Int
    var flag = true
    while (true){

        i++
        if (i == list.size - 1){
            break
        }
        j=i+1
        while (true){

            //println("check " + list[i] + " and " + list[j])

            val first = list[i]
            val second = list[j]

            val che = check(list[i], list[j])
            if (che != null){
                list.remove(first)
                list.remove(second)
                list.add(che)
                flag = false
            }else{
                j++
            }
            if (!flag || j == list.size) break
        }

        if (!flag){
            i = -1
            flag = true
        }
    }

    //println(list)
    if (list.size == 1){
        println(-1)
    }else{
        for (k in 0..count){
            if (list[0].indexes.contains(k)){
                print(1)
            }else{
                print(2)
            }
            print(" ")
        }
    }
}

fun contains(i1: Interval, i2: Interval): Interval?{
    if (i1.left >= i2.left && i1.left < i2.right && i1.right > i2.left && i1.right <= i2.right){
        //println(Interval(i2.left, i2.right, i2.indexes.plus(i1.indexes)))
        return Interval(i2.left, i2.right, i2.indexes.plus(i1.indexes))
    }
    return null
}

fun cross(i1: Interval, i2: Interval): Interval?{
    if (i2.left > i1.left && i2.left < i1.right && i1.right < i2.right){
        //println(Interval(i1.left, i2.right, i1.indexes.plus(i2.indexes)))
        return Interval(i1.left, i2.right, i1.indexes.plus(i2.indexes))
    }
    return null
}

fun touch(i1: Interval, i2: Interval): Interval?{
    if (i1.right == i2.left){
        //println(Interval(i1.left, i2.right, i1.indexes.plus(i2.indexes)))
        return Interval(i1.left, i2.right, i1.indexes.plus(i2.indexes))
    }
    return null
}
