package com.eric.kotlin.demo.dataBean

/**
 * author : Eric
 * e-mail : yuanshuai@bertadata.com
 * time   : 2017/06/14
 * desc   : git repo 数据类
 * version: 1.0
 */

data class GitDataBean(var status:String, var message:String, val repo:String):BaseDataBean(status, message)
