package com.example.helloworld

import kotlin.math.max

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

    val person = Person()
    person.name = "Jack"
    person.age = 19
    person.eat()
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