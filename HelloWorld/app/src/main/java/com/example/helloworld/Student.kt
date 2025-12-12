package com.example.helloworld

/**
 * 为什么Person类的后面要加上一对括号呢？
 *
 * 任何一个面向对象的编程语言都会有构造函数的概念，Kotlin中也有，但是Kotlin将构造函数分成了两种：主构造函数和次构造函数。主构造函数只能有一个，次构造函数可以有多个。当一个类既有主构造函数又有次构造函数时，所有的次构造函数都必须调用主构造函数（包括间接调用）。
 *
 * 主构造函数将会是你最常用的构造函数，每个类默认都会有一个不带参数的主构造函数
 */
class StudentA : Person() {
    var sno: String = ""
    var grade: Int = 0
}
/**
 * 当然你也可以显式地给它指明参数。主构造函数的特点是没有函数体，直接定义在类名的后面即可。比如下面这种写法：
 */
class StudentA1(val sno: String, val grade: Int) : Person() {
}
/**
 * 如果我想在主构造函数中编写一些逻辑代码，在`init`中编写
 */
class StudentA2(val sno: String, val grade: Int) : Person() {
    init {
        println("sno is " + sno)
        println("grade is " + grade)
    }
}

/**
 * 但是这和那对括号又有什么关系呢？
 *
 * 这就涉及了Java继承特性中的一个规定，子类中的构造函数必须调用父类中的构造函数，这个规定在Kotlin中也要遵守。
 *
 * 根据继承特性的规定，子类的构造函数必须调用父类的构造函数，可是主构造函数并没有函数体，我们怎样去调用父类的构造函数呢？你可能会说，在`init`结构体中去调用不就好了。这或许是一种办法，但绝对不是一种好办法，因为在绝大多数的场景下，我们是不需要编写`init`结构体的。
 *
 * 注意，我们在Student类的主构造函数中增加name和age这两个字段时，不能再将它们声明成`val`，因为在主构造函数中声明成`val`或者`var`的参数将自动成为该类的字段，这就会导致和父类中同名的name和age字段造成冲突。因此，这里的name和age参数前面我们不用加任何关键字，让它的作用域仅限定在主构造函数当中即可。
 */
class Student1A(val sno: String, val grade: Int, name: String, age: Int) : Person1(name, age) {
}

/**
 * 次构造函数是通过constructor关键字来定义的
 */
open class Student1B(val sno: String, val grade: Int, name: String, age: Int) : Person1(name, age) {
    // 这次构造函数个接收name和age参数，然后它又通过this关键字调用了主构造函数，并将sno和grade这两个参数赋值成初始值
    constructor(name: String, age: Int) : this("", 0, name, age) {
    }
    // 这个次构造函数不接收任何参数，它通过this关键字调用了上一个次构造函数，并将name和age参数也赋值成初始值，由于上一个次构造函数间接调用了主构造函数，因此这仍然是合法的
    constructor() : this("", 0) {
    }
}
class GoodStudent1B1 : Student1B() {
    var score: Int = 0
}
class GoodStudent1B2() : Student1B() {
    var score: Int = 0
}
class GoodStudent1B3 : Student1B("Jack", 19) {
    var score: Int = 0
}
class GoodStudent1B4 : Student1B(sno = "123", grade = 1, name = "Jack", age = 19) {
    var score: Int = 0
}

/**
 * 一种非常特殊的情况：类中只有次构造函数，没有主构造函数。
 *
 * 这种情况真的十分少见，但在Kotlin中是允许的。当一个类没有显式地定义主构造函数且定义了次构造函数时，它就是没有主构造函数的。
 *
 * 注意这里的代码变化，首先Student类的后面没有显式地定义主构造函数，同时又因为定义了次构造函数，所以现在Student类是没有主构造函数的。那么既然没有主构造函数，继承Person类的时候也就不需要再加上括号了。其实原因就是这么简单，只是很多人在刚开始学习Kotlin的时候没能理解这对括号的意义和规则，因此总感觉继承的写法有时候要加上括号，有时候又不要加，搞得晕头转向的，而在你真正理解了规则之后，就会发现其实还是很好懂的。
 *
 * 另外，由于没有主构造函数，次构造函数只能直接调用父类的构造函数，上述代码也是将`this`关键字换成了`super`关键字，这部分就很好理解了，因为和Java比较像，我也就不再多说了。
 */
class Student1C : Person1 {
    constructor(name: String, age: Int) : super(name, age) {
    }
}