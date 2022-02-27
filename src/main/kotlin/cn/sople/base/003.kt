package cn.sople.base

/**
 * rang 表达式
 */

fun main(){
    var number = 98
    //if 是表达式，是有返回值的
    var name = if(number in 10..59){
        "不及格"
    }else if(number in 60..90){
        "及格"
    }else if(number in 90..100){
        "优秀"
    }else{
        "错误"
    }
    println(name)
}