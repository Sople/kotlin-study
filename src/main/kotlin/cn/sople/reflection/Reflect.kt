package cn.sople.reflection

import com.squareup.moshi.Json
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.findAnnotations
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

/**
 *@Description
 *@Author PC
 *@QQ 1578684787
 */
class Student

//模型数据
@Table(name = "lyc_profiles")
data class User(
    @Json(name="member_id")  var id:Int,
    @ColumnInfo(name = "pro_name")  var name:String,
    @ColumnInfo(name = "lyc_icon")  var icon:String
){
    override fun toString(): String {
        return "User(id=$id,name='$name',icon='$icon')"
    }
}

//表明 -> 类名 一一对应
//类注解
//Retention默认值为AnnotationRetention.RUNTIME
@Retention
@Target(AnnotationTarget.CLASS)
annotation class Table(val name: String)

//属性注解
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.PROPERTY)
annotation class ColumnInfo(val name: String)

//模拟数据的查询
fun selectData():Map<String,Map<String,Any>>{
    //模拟有两个表User Student
    //使用Map封装数据
    val userData = mapOf(
        Pair("id",1),
        Pair("name","joke"),
        Pair("icon","www.google.com")
    )
    val studentData = mapOf(
        Pair("Sid",1),
        Pair("name","李王开"),
        Pair("address","西南大学")
    )

    return mapOf(
        Pair("User",userData),
        Pair("Student",studentData)
    )
}


fun autoParseFromTable(modelClz: KClass<out Any>):Any?{
    //先从数据库中读取出表的对应数据
    val datas = selectData()
    //判断传递过来的KClass对象有没有Entity注解
    val entity = modelClz.findAnnotation<Table>()

    val columnInfo = modelClz.findAnnotation<ColumnInfo>()

    return if (entity==null){
        //传递过来的类没有Entity注解
        //不能进行转换
        null
    }else{

        modelClz.memberProperties.forEach { it ->
            val columnInfo = it.findAnnotation<ColumnInfo>()
            val columnName = columnInfo?.name
            val jsonInfo = it.findAnnotation<Json>()
            val i = 2
        }
        //如果传递过来的类有Entity注解
        //就创建对象实例
        //获取表名
        val tableName = modelClz.simpleName
        val info = datas[tableName]

        //创建对象 将info的数据 填充到对象对应的属性中
        //使用默认的主构造函数创建

        val constructor = modelClz.primaryConstructor
        //创建一个数组保存解析的属性值
        //创建的数组元素个数 和 构造函数中参数的个数相同 初始值为null
        val params = arrayOfNulls<Any>(constructor!!.parameters.size)

        //遍历构造函数的参数
        constructor.parameters.forEach{
            //从数据源中获取这个参数对应的值
            val value = info?.get(it.name)
            //将这个值保存到数组中
            params[it.index] = value
        }
        //调用构造函数创建对象
        //将一个数组传递给可变参数时 需在参数名前加*
        //vararg 对应的是Array类型的数组 不能是List
        constructor?.call(*params)
    }
}

class AnnotaionTest<T:Any>{
    fun praseObject(user: T){
        val clazz = user::class
        val tableName = clazz.findAnnotation<Table>()?.name
        val members = clazz.memberProperties
        members.forEach {
            val columnInfo = it.findAnnotation<ColumnInfo>()
            val columnName = columnInfo?.name
            val jsonInfo = it.findAnnotation<Json>()
            val i = 2
        }
    }
}



fun main(){

    val user = User(1234,"what is","wiibjk,ydi")

    AnnotaionTest<User>().praseObject(user)

//    val user = autoParseFromTable(User::class) as User
//    println(user.id)

}