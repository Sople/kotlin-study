package cn.sople.base

/**
 * 字符串模板
 */
fun main(){
    var garden = "黄石公园"
    var time = 6
    println("今天天气好，我们去${garden},玩了$time 个小时")
    var isLogin = true
    println("服务器状态：${if (isLogin) "登录" else "关闭"}")
}