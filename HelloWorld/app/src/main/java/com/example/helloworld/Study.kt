package com.example.helloworld

// 接口是用于实现多态编程的重要组成部分

interface Study {
    fun readBooks()

    /**
     * 本接口有默认实现的方法
     */
    fun doHomework() {
        println("do homework default implementation")
    }
}