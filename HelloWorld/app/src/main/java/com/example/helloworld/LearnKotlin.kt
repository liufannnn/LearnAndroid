package com.example.helloworld

import kotlin.math.max

fun main() {
    val a: Int = 10
    val b: Int = 20
    val larger = largerNumber(a, b)
    println(message = "larger = " + larger)
    val num = 10L
    checkNumber(num)
    forInFunc()
}

// if 条件语句
fun largerNumber(num1: Int, num2: Int): Int {
    /*
    var value = 0
    if (num1 > num2) {
        value = num1
    } else {
        value = num2
    }
    */
    return if (num1 > num2) {
        num1
    } else {
        num2
    }
}
// 语法糖
fun largerNumber2(num1: Int, num2: Int): Int = if (num1 > num2) num1 else num2
// 类型推导
fun largerNumber3(num1: Int, num2: Int) = max(num1, num2)

// when 条件语句
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

// 循环语句
fun whileFunc(num: Int) {
    var a = num
    while (a > 10) {
        a -= 1
        println("减1")
    }
}
fun forInFunc() {
    // for (a in 0..10) { // [0,10]
    // for (a in 0 until 10) { // [0,10)
    // for (a in 0 until 10 step 2) { // [0,10)，每次执行循环都会在区间范围内递增2
    // for (a in 10 downTo 1) { // [10,1]降序区间
    for (a in 10 downTo 1 step 2) { // [10,1]降序区间递减2
        println("数字" + a)
    }
}