package cn.sople.base

/**
 * when表达式
 */
fun main(){
    var week = 8
    //Any相当于java中的Object
    var name = when(week){
        1 -> "周一"
        2 -> "周二"
        3 -> "周三"
        4 -> "周四"
        5 -> "周五"
        6 -> "周六"
        7 -> "周日"
        8 -> 88
        else -> {
            "错误"
        }
    }
    println(name)
}