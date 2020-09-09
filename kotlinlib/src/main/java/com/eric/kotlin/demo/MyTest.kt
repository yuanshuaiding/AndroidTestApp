package com.eric.kotlin.demo

/**
 * author : Eric
 * e-mail : yuanshuai@bertadata.com
 * time   : 2017/06/08
 * desc   : 常量定义
 * version: 1.0
 */
const val SUBSYSTEM_DEPRECATED:String="This subsystem is deprecated"

class MyTest {
    @Deprecated(SUBSYSTEM_DEPRECATED, ReplaceWith("foo2()")) //常量还可以用在注解中使用
    fun foo(){
        //...
        println(SUBSYSTEM_DEPRECATED)
    }

    fun foo2(){
        //...
    }

    fun test(){
        println("test")
    }
}