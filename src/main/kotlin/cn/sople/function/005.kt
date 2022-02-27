package cn.sople.function

/**
 * 匿名函数=lambda
 * 函数声明与函数实现的分离
 */

fun main() {
    //函数的声明,定义一个无参函数，返回值类型为string , 函数名称为methodAction
    var methodAction: () -> String
    //函数的实现
    methodAction = {
        println("这个是函数的实现")
        //最后一行的函数的返回值,不需要写return关键字
        "return"
    }
    methodAction()

    //函数的声明,定义一个有参函数，返回值类型为string , 函数名称为methodAction02
    var methodAction02: (Int, Float) -> String
    //函数的实现
    methodAction02 = { age, money ->
        println("这个是有参函数的实现,age=${age},money=${money}")
        //最后一行的函数的返回值,不需要写return关键字
        "success"
    }
    methodAction02(25, 23.3F)

    //函数定义的合并写法
    var methodAction03: (Int, Float) -> String = { age, money ->
        println("这个是合并定义函数的实现,age=${age},money=${money}")
        //最后一行的函数的返回值,不需要写return关键字
        "success"
    }

    methodAction03(35, 28.3F)
    //函数的另一种调用方式
    methodAction03.invoke(35, 28.3F)

    /**
     * it 关键字
     */
    //当函数只有一个参数的时候，函数体中可以直接使用it来指代参数的值
    var methodAction04: (Int) -> String = {
        println("这个是使用it关键字的函数实现,age=${it}")
        //最后一行的函数的返回值,不需要写return关键字
        "success"
    }
    methodAction04(100)
}