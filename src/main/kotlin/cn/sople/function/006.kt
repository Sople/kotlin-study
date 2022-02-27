package cn.sople.function

/**
 * 匿名函数的类型推断
 * 匿名函数=lambda
 */

fun main() {
    //匿名函数也可以省去定义部分，直接写实现部分
    var methodAction = { age: Int, name: String, money: Float ->
        println("匿名函数：age=${age},name=${name},money=${money}")
        "success"
    }
    println( methodAction(28,"ccc", 345.6F))

    //无返回值函数
    var method02={
        3.1415925F
        Unit
    }
    println(method02)
}