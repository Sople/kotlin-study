package cn.sople.function

/**
 * 函数的参数为函数
 */

fun main() {
    var loginFun = { user: String, password: String ->
        true
    }
    //第一种函数调用方式
    serverLogin("server001", "keijiefjie", loginFun)
    //第二种函数调用方式
    serverLogin("server001", "keijiefjie", loginServer = { user: String, password: String ->
        true
    })
    //第三种函数调用方式
    //如果lambda 表达式是最后一个参数，可以提到函数外边。该写法与上面的写法功能一致
    serverLogin("server001", "keijiefjie") { user: String, password: String ->
        true
    }
}

fun serverLogin(user: String, password: String, loginServer: (String, String) -> Boolean) {
    if (loginServer(user, password)) {
        println("Server 登录成功:user=${user},password=${password}")
    }
}