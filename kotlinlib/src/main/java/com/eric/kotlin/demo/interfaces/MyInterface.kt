package com.eric.kotlin.demo.interfaces

/**
 * author : Eric
 * e-mail : yuanshuai@bertadata.com
 * time   : 2017/06/09
 * desc   : 接口示例
 * version: 1.0
 */
interface MyInterface {

    val prop: String

    val name: String
        get() = "foo"

    fun foo()
}

interface Interface2{
    fun bar(){
        println("interface 2")}
}

class ImpledMyInterface : MyInterface ,Interface2{
    override val prop: String
        get() = ""

    override fun foo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}