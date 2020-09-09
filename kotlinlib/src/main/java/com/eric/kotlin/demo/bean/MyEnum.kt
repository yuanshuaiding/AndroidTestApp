package com.eric.kotlin.demo.bean

/**
 * author : Eric
 * e-mail : yuanshuai@bertadata.com
 * time   : 2017/07/07
 * desc   : 枚举类
 * version: 1.0
 */
enum class MyEnum {
    ENUM0, ENUM1, ENUM2, ENUM3
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}

enum class ProtocolState(val type: Int) {
    //匿名内部类的方式声明 WAITING 枚举常量
    WAITING(0) {
        //使用get方法重新给属性赋值（此时的类型声明String可以省略，自动推断）
        override val protocolName: String
            get() = "wait" //直接返回确定值给get()函数

        //必须要实现抽象方法
        override fun signal(): ProtocolState = WAITING
    },
    TALKING(1) {
        //使用get方法重新给属性赋值（此时不能省略类型声明String，因为Kotlin无法对get方法体的返回进行推断）
        override val protocolName: String
            get() {
                return "talk" //通过方法体返回值
            }

        override fun signal(): ProtocolState = TALKING

        //声明仅属于TALKING枚举常量的属性,但外部无法访问
        var protocolTalk = "protocol talk"

        //声明仅属于TALKING枚举常量的函数，但外部无法访问
        fun talk() {
            println("talking")
        }

    },
    SITING(2) {
        //直接赋值给属性实现重写，此时可以省略类型声明String
        override val protocolName = "sit"

        //直接赋值给方法，此时可以省略类型声明ProtocolState
        override fun signal() = SITING
    },
    NONE(-1) {
        override fun signal(): ProtocolState {
            return NONE
        }
    };  //如果枚举类还有枚举常量以外的声明，如属性或方法等，此处的分号就必须出现，用于标识枚举常量声明的结束


    open val protocolName: String = ""
    abstract fun signal(): ProtocolState
}