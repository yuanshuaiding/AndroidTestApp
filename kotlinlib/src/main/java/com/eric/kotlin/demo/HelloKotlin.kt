package com.eric.kotlin.demo

import com.eric.kotlin.demo.bean.*
import com.eric.kotlin.demo.dataBean.GitDataBean
import com.eric.kotlin.demo.interfaces.MyJavaInterface
import io.reactivex.Observable
import org.w3c.dom.events.MouseEvent
import java.awt.event.ActionListener
import java.util.concurrent.Executors

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
val items = listOf("apple", "banana", "kiwi", "orange")

data class Hello(val name: String, val age: Int)

enum class Lang(val hi: String) {
    ENGLISH("hello"),
    CHINESE("你好");

    fun sayHello() {
        println(hi)
    }

    companion object {
        fun parse(name: String): Lang? {
            return Lang.valueOf(name.toUpperCase())
        }
    }
}

fun main(args: Array<String>) {


    Observable.fromIterable(items)
            .filter { item -> item.contains("a") }
            .map(::println)
            .subscribe()
    val worker = Executors.newCachedThreadPool()
    worker.execute { println("hello java worker pool") }
    if (args.isNotEmpty()) {
        Lang.parse(args[0])?.sayHello()
    }


    val newArgs = args.map(::convertArgs)

    newArgs.map(::println)

    newArgs.flatMap { arg -> arg.split("_") }.map(::println)

    val hello = Hello("Eric", 29)
    println(hello)

    val c: Int
    c = 2
    "".isNullOrEmpty()
    c.toString()
    println("hello kotlin")
    println("2+3=${sum(2, 3)}")
    println("4+5=${sum1(4, 5)}")
    printSum(a, b)
    printSum(b, c)
    printSum(6, 7)
    printPrice("45", "2q")
    printLength("hello kotlin")

    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))

    val x = 9
    val y = 10
    if (x in 1..y) {
        println("$x is in range of 1~$y")
    }

    if (-1 !in 0..items.lastIndex) {
        println("-1 is out of range")
    }

    if (items.size !in items.indices) {
        println("list size is out of valid list indices range too")
    }

    if ("kiwi" in items) {
        println("kiwi is in the list")
    }

    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    for (a in items) {
        println(a)
    }

    for (a in 1..5) {
        println(a)
    }

    for (a in 5 downTo 0) {
        println(a)
    }

    for (a in 1..5 step 2) {
        println(a)
    }
    items
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach(::println)

    val intArrs: IntArray = intArrayOf(0, 1, 2, 3)
    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |    --(Benjamin Franklin)
    """.trimMargin()

    println(text)

    for (ch in text) {
        print(ch)
    }

    println("")

    text.map { it -> it.toUpperCase() }.map(::print)

    println(text)

    val doller = """
${'$'}prise9.99
"""

    println(doller)
    var p: GitBean? = GitBean("张三", "")
    if (p != null) {
        p.no = "123"
    }
    val author = p?.author ?: fail("author can't be empty")

    println("名字/编号：" + author + "/" + p.no)

    for ((index, value) in items.withIndex()) {
        println("the element at $index is $value")
    }

    println(SUBSYSTEM_DEPRECATED)
    println(MyJavaInterface.prop)

    fun innerFun(): String? {
        var result = ""
        items.forEach {
            if (it.equals("banana", true)) {
                result = it
                return@forEach
            }
            println(it)
        }
        return result
    }
    println(innerFun())
    println("哈哈哈.....")

    println("items 集合最后的索引为：${items.theLastIndex}")
    val gb = GitDataBean("0", "success", "tom-repo")
    val gb_c = gb.copy(repo = "jim")
    println(gb)
    println(gb_c)
    val (status, message, repo) = gb

    val red = RED(0xfff000)

    eval(red)

    var objList = listOf<Any>(1, "a", GitBean("tom"))
    var strLIst = listOf<String>("a", "b", "c")
    //strLIst=objList
    objList = strLIst
    val adapter=ActionListener{e-> println(e)}
    onWindowClick(object : MyAdapter {
        override fun mouseClick(e: MouseEvent) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    })
    ProtocolState.valueOf("TALKING")

    printAllValues<ProtocolState>()
}

fun eval(ex: MySealedClass) = when (ex) {
    is RED -> println("color is RED:${ex.rgb}")
    is BLUE -> println("color is BLUE")
}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}


fun convertArgs(s: String): String {
    return "new_" + s
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

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printPrice(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    // 直接使用 x*y 会产生错误因为它们中有可能会有空值
    if (x != null && y != null) {
        // x 和 y 将会在空值检测后自动转换为非空值
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // obj 将会在这个分支中自动转换为 String 类型
        return obj.length
    }

    // obj 在种类检查外仍然是 Any 类型
    return null
}

fun printLength(obj: Any) {
    println("'$obj' string length is ${getStringLength(obj) ?: "... err, is empty or not a string at all"} ")
}

fun describe(obj: Any): String = when (obj) {
    1 -> "One"
    "Hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "Not a string"
    else -> "unknown"
}

//属性拓展

val <T> List<T>.theLastIndex: Int
    get() = this.size - 1

class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo() = 2
    }

    inner class Inner {
        fun foo() = bar
    }
}

interface MyAdapter {
    fun mouseClick(e: MouseEvent)
}

fun onWindowClick(adapter: MyAdapter) {

}