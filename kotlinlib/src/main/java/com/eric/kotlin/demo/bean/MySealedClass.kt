package com.eric.kotlin.demo.bean

/**
 * author : Eric
 * e-mail : yuanshuai@bertadata.com
 * time   : 2017/06/14
 * desc   : xxxx描述
 * version: 1.0
 */
sealed class MySealedClass(open val rgb: Int)

class RED(override val rgb: Int) : MySealedClass(rgb)
class BLUE(override val rgb: Int) : MySealedClass(rgb)