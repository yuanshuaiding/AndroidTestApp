package com.eric.kotlin.demo

/**
 * author : Eric
 * e-mail : yuanshuai@bertadata.com
 * time   : 2017/05/25
 * desc   : 线程安全的单例模式
 * version: 1.0
 */
class SingleInstanceLazy private constructor(){
    val instance:SingleInstanceLazy by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        SingleInstanceLazy()
    }

    companion object{
        fun getInstance(): SingleInstanceLazy {
            return SingleInstanceLazy()
        }
    }
}