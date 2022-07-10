package cn.sople.function

/**
 * 内联关键字
 * 函数参数中如果存在lambda，此函数就应该使用内联inline，避免运行中过多嵌套调用的性能损耗。
 */

fun main() {
    var loginFun = { user: String, password: String ->
        true
    }
//    //第一种函数调用方式
//    serverLogin("server001", "keijiefjie", loginFun)
//    //第二种函数调用方式
//    serverLogin02("server001", "keijiefjie", loginServer = { user: String, password: String ->
//        true
//    })
//    //第三种函数调用方式
//    //如果lambda 表达式是最后一个参数，可以提到函数外边。该写法与上面的写法功能一致
//    serverLogin02("server001", "keijiefjie") { user: String, password: String ->
//        true
//    }
}
//函数参数中如果存在lambda，此函数就应该使用内联inline，避免运行中过多嵌套调用的性能损耗。
//inline fun serverLogin02(user: String, password: String, loginServer: (String, String) -> Boolean) {
//    if (loginServer(user, password)) {
//        println("Server 登录成功:user=${user},password=${password}")
//    }
//}