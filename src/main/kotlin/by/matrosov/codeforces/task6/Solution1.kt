

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

    val list = mutableListOf<Interval>()

    val numberOfRequests = readLine()!!.toInt()
    for (n in 0 until numberOfRequests){

        val numberOfIntervals = readLine()!!.toInt()
        for (p in 0 until numberOfIntervals){
            val string = readLine()!!.split(" ")
            val l = string[0].toInt()
            val r = string[1].toInt()
            list.add(Interval(l,r, setOf(p)))
        }

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
            println()
        }
        list.clear()
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
