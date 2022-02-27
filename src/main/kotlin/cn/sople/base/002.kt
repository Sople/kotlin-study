package cn.sople.base
/**
 * 只读变量
 * 类型推断
 * 编译时常量
 */
//编译时常量，只能定义于函数之外，函数之内的变量是在运行时被赋值的。
//编译时常量是在编译时被赋值
const val PI = 3.1415926
fun main(){
    //val 变量一旦被赋值，就无法再被改变。程序开发过程中尽量使用val去代替var,更安全。
    val info:String = "my info"
    println("info is : $info")
    //kotlin类型推断：编译器根据变量实际值推断变量类型，变量类型一旦确定就不可以改变。
    val name = "this is a string"
    println(name)
    val age = 35
    println(age)
    val letter = 'A'
    println(letter)
    //kotlin中定义的数值类型，在实际计算中都会根据需要转换成java的基本数据类型，无需担心性能问题

}