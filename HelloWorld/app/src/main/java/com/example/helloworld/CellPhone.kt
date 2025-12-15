package com.example.helloworld

/**
 * 数据类，只需要一行代码就可以实现CellPhoneJava！
 *
 * 神奇的地方就在于`data`这个关键字，当在一个类前面声明了`data`关键字时，就表明你希望这个类是一个数据类，Kotlin会根据主构造函数中的参数帮你将equals()、hashCode()、toString()等固定且无实际逻辑意义的方法自动生成，从而大大减少了开发的工作量。
 */
data class CellPhone(val brand: String, val price: Double) // 当一个类中没有代码时，大括号也可以省略