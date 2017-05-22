package com.eric.kotlin.demo

/**
 * author : Eric
 * e-mail : yuanshuai@bertadata.com
 * time   : 2017/05/18
 * desc   : Kotlin示例
 * /**
这是嵌套的注释
*/
 * version: 1.0
 */

val a = 0
val b = 1


fun main(args: Array<String>) {
    val c: Int
    c = 2
    println("hello kotlin")
    println("2+3=${sum(2, 3)}")
    println("4+5=${sum1(4, 5)}")
    printSum(a, b)
    printSum(b, c)
    printSum(6, 7)

}

//函数的定义（指定返回值类型）
fun sum(a: Int, b: Int): Int {
    return a + b
}

//函数的定义1（自动推断返回值类型）
fun sum1(a: Int, b: Int) = a + b

//函数的定义（无返回值）
fun printSum(a: Int, b: Int) {
    println("$a+$b=${sum(a, b)}")
}

fun max(a: Int, b: Int) {
    //把if当表达式使用
    if (a > b) a else b
}

fun parseInt(str: String):Int?{
    return null
}