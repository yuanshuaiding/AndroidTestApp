package com.eric.kotlin.demo.bean

import com.eric.kotlin.demo.SingleInstance

/**
 * author : Eric
 * e-mail : yuanshuai@bertadata.com
 * time   : 2017/06/01
 * desc   : GitHub repos对应的类
 * version: 1.0
 */
class GitBean(name: String) : BaseBean(name) {
    override var no: String? = ""
            //自定义get访问器
        get() {
            if (!field.isNullOrEmpty())
                return field + "_get"
            else
                return "empty"
        }
            //自定义set访问器
        set(value) {
            if (!value.isNullOrEmpty()) {
                field = value + "_set"
            }
        }
    var author: String = "default"
    private var url: String = ""
    private val header: String = ""
        get() {
            return field + "_header"
        }

    constructor(name: String, url: String) : this(name) {
        this.author = name
        this.url = url
    }

    init {
        println("GitBean is inited! and author name is ${super.id}")
    }

}

open class BaseBean(id: String) {
    var id: String?
    open var no: String? = null

    init {
        this.id = id
        var single = SingleInstance
    }

    constructor(id: String, no: String) : this(id) {
        this.no = no
    }
}

abstract class P {
    abstract fun a()
}