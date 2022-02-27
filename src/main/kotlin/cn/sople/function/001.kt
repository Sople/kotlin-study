package cn.sople.function

/**
 * 函数头
 */

fun main(){
    //基本函数
    method01("llll",25)
    //参数默认值函数
    method02("aaa")
    method02("aaa",35)
    //函数具名参数调用
    method01(age = 23, name = "bbbb")
    //Unit函数
    method03("ccc",40)
    method04("ddd",41)
}

//函数默认是public
private fun method01(name: String, age: Int): Int{
    println("这个人的名字是：${name},年龄是：${age}")
    return 200
}

//函数参数的默认值
private fun method02(name: String, age: Int = 77): Int{
    println("这个人的名字是：${name},年龄是：${age}")
    return 200
}

//Unit函数
//Unit相当于java的void关键字，标记函数无返回值
private fun method03(name: String, age: Int): Unit{
    println("这个人的名字是：${name},年龄是：${age}")
}
private fun method04(name: String, age: Int){
    println("这个人的名字是：${name},年龄是：${age}")
}

