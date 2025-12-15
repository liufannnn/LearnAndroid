package com.example.helloworld

import kotlin.math.max

/**
 * 函数可见性修饰符
 *
 * 1. `public`，所有类可见，默认
 * 1. `internal`，同一模块中的类可见
 * 1. `protected`，当前类、子类可见
 * 1. `private`，当前类可见
 */
fun main() {
    // if条件语句
    // ifFunc()

    // when条件语句
    // val num = 10L
    // checkNumber(num)

    // while循环语句（while循环语句与C语言相同）
    // whileFunc()

    // for-in循环语句
    // forInFunc()

    // 封装、继承与多态
    // val student = Student("Jack", 19)
    // student.eat()
    // doStudy(student)

    // 数据类
    // val cellPhone1 = CellPhone("Samsung", 1299.99)
    // val cellPhone2 = CellPhone("Samsung", 1299.99)
    // println(cellPhone1)
    // println("cellPhone1 equals cellPhone2 = " + (cellPhone1 == cellPhone2))

    // 单例类
    // Singleton.singletonTest()

    // 集合的Lambda函数式API
    // lamdbaFunc()
    // lamdbaJavaFunc()

    // 键值对方式传参时，无所谓键值对的顺序
    // printParams(str = "hello", num = 100)
}

// <editor-fold defaultstate="collapsed" desc="if条件语句">
fun ifFunc() {
    val a: Int = 10
    val b: Int = 20
    val larger = largerNumber(a, b)
    println(message = "larger = " + larger)
}
fun largerNumber(num1: Int, num2: Int): Int {
    var value = 0
    if (num1 > num2) {
        value = num1
    } else {
        value = num2
    }
    return value
}
/**
 * `if`条件语句
 *
 * Kotlin的`if`语句有一个额外功能，他是可以有返回值的
 */
fun largerNumber1(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        num1
    } else {
        num2
    }
}
/**
 * `if`条件语句，函数语法糖
 *
 * 函数只有一行代码时，可以不必编写函数体，直接将唯一的一行代码写在函数定义的尾部，中间用`=`连接
 *
 * 虽然 `largerNumber1` 函数体不止一行代码，但是他和只有一行代码的作用时相同的，只是返回了一下`if`语句的返回值而已，符合该语法糖的使用条件
 */
fun largerNumber2(num1: Int, num2: Int): Int = if (num1 > num2) num1 else num2
/**
 * `if`条件语句，函数语法糖
 *
 * 返回值类型推导
 */
fun largerNumber3(num1: Int, num2: Int) = max(num1, num2)
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="when条件语句">
fun getScore(name: String) = if (name == "Tom") {
    86
} else if (name == "Jim") {
    77
} else if (name == "Jack") {
    95
} else if (name == "Lily") {
    100
} else {
    0
}
/**
 * `when`条件语句
 *
 * 格式：匹配值 -> 执行逻辑
 */
fun getScore1(name: String) = when (name) {
    "Tom" -> 86 // { 86 }
    "Jim" -> 77
    "Jack" -> 95
    "Lily" -> 100
    else -> 0
}
fun getScore2(name: String) = when {
    name.startsWith("Tom") -> 86 // Tom、Tommy
    name == "Jim" -> 77
    name == "Jack" -> 95
    name == "Lily" -> 100
    else -> 0
}
fun checkNumber(num: Number) {
    when (num) {
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number not support")
    }
}
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="while循环语句">
fun whileFunc(num: Int) {
    var a = num
    while (a > 10) {
        a -= 1
        println("减1")
    }
}
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="for-in循环语句">
fun forInFunc() {
    // for (a in 0..10) { // [0,10]
    // for (a in 0 until 10) { // [0,10)
    // for (a in 0 until 10 step 2) { // [0,10)，每次执行循环都会在区间范围内递增2
    // for (a in 10 downTo 1) { // [10,1]降序区间
    for (a in 10 downTo 1 step 2) { // [10,1]降序区间递减2
        println("数字" + a)
    }
}
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="封装、继承与多态">
/**
 * 这里为了向你演示一下多态编程的特性，我故意将代码写得复杂了一点。
 *
 * 首先创建了一个Student类的实例，本来是可以直接调用该实例的readBooks()和doHomework()函数的，但是我没有这么做，而是将它传入到了doStudy()函数中。
 * doStudy()函数接收一个Study类型的参数，由于Student类实现了Study接口，因此Student类的实例是可以传递给doStudy()函数的，
 * 接下来我们调用了Study接口的readBooks()和doHomework()函数，这种就叫作面向接口编程，也可以称为多态。
 */
fun doStudy(study: Study?) {
    /*
    if (study != null) {
        study.readBooks()
        study.doHomework()
    }
    */

    // study?.readBooks() // 这样就相当于每次都要判空一下
    // study?.doHomework() // 这样就相当于每次都要判空一下

    study?.let {
        it.readBooks()
        it.doHomework()
    }
}
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="集合的Lambda函数式API">
/**
 * 集合的Lambda函数式API，Lambda就是一小段可以作为参数传递的代码
 *
 * 格式：{ 参数名: 参数类型, 参数名: 参数类型 -> 函数体 }
 *
 * 函数体中可以编写任意行代码，最后一行代码自动作为Lamdba表达式的返回值
 */
fun lamdbaFunc() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")

    // val lamdba = { fruit: String -> fruit.length }
    // val maxLengthFruit = list.maxBy(lamdba)

    // 当Lambda参数是函数的最后一个参数时，可以将Lambda表达式移到函数括号的外面
    // val maxLengthFruit = list.maxBy({ fruit: String -> fruit.length })

    // Lambda参数是函数的唯一一个参数的话，还可以将函数的括号省略
    // val maxLengthFruit = list.maxBy() { fruit: String -> fruit.length }

    // 由于Kotlin拥有出色的类型推导机制，Lambda表达式中的参数列表其实在大多数情况下不必声明参数类型
    // val maxLengthFruit = list.maxBy { fruit -> fruit.length }

    // Lambda表达式的参数列表中只有一个参数时，也不必声明参数名，而是可以使用it关键字来代替
    val maxLengthFruit = list.maxBy { it.length }
    println("max length fruit is " + maxLengthFruit)

    val newList = list.filter { it.length <= 5 }.map { it.toUpperCase() }
    for (fruit in newList) {
        println(fruit)
    }

    val anyResult = list.any { it.length <= 5 } // 判断集合中是否至少存在一个元素满足指定条件
    val allResult = list.all { it.length <= 5 } // 判断集合中是否所有元素都满足指定条件
    println("anyResult is " + anyResult + ", allResult is " + allResult)
}

/**
 * 在Kotlin代码中调用一个Java方法，并且该方法接收一个Java单抽象方法接口参数，就可以使用函数式API
 */
fun lamdbaJavaFunc() {
    Thread(object : Runnable { // 匿名类写法
        override fun run() {
            println("Thread1 is running")
        }
    }).start()

    // Lambda写法，即使这里没有显式地重写run()方法，Kotlin也能自动明白Runnable后面的Lambda表达式就是要在run()方法中实现的内容。
    Thread(Runnable {
        println("Thread2 is running")
    }).start()

    // 一个Java方法的参数列表中有且仅有一个Java单抽象方法接口参数，我们还可以将接口名进行省略
    Thread({
        println("Thread3 is running")
    }).start()

    // 当Lambda参数是函数的最后一个参数时，可以将Lambda表达式移到函数括号的外面
    // Lambda参数是函数的唯一一个参数的话，还可以将函数的括号省略
    Thread {
        println("Thread4 is running")
    }.start()
}
// </editor-fold>

fun printParams(num: Int = 100, str: String) {
    println("num is $num, str is $str")
}