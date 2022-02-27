package cn.sople.function

/**
 * 匿名函数
 */

fun main(){
    var len = "ljijfiejfie".count()
    println("字符串长度是：${len}")
    //匿名函数
    var len_f = "ljijfiejfie".count{
        it == 'f'
    }
    println("长度是：${len_f}")
}