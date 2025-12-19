package com.example.learnjava;

import java.util.Arrays;
import java.util.Scanner;

/// 一个Java源文件可以包含多个类的定义，但只能定义一个public类，且public类名必须与文件名一致。
/// 如果要定义多个public类，必须拆到多个Java源文件中。
///
/// 在Java中，没有明确写 extends 的类，编译器会自动加上 extends Object。
/// 所以除了 Object，任何类都会继承自某个类。
///
/// Java只允许一个class继承自一个类，因此一个类有且仅有一个父类。只有 Object 特殊，它没有父类。
public class Hello {
    public static void main(String[] args) {
        helloWorld();
        Student.func();
    }

    // 1、变量
    // 在Java中，变量类型分为两种:基本类型和引用类型。

    // <editor-fold defaultstate="collapsed" desc="1.1、基本类型">
    /**
     * 整型
     * <p>
     * 计算机内存的最小存储单元是字节(byte)，一个字节8个比特(bit)。二进制范围00000000 ~ 11111111，换算成十进制是0 ~ 255，换算成十六进制是00 ~ ff。
     * <p>
     * Java只定义了带符号的整型，因此最高位的bit表示符号位(0表示正数，1表示负数)。
     * <p>
     * @byte  字节数1，值范围-128 ~ 127
     * @short 字节数2，值范围-32768 ~ 32767
     * @int   字节数4，值范围-2147483648 ~ 2147483647，默认值为0
     * @long  字节数8，值范围-9223372036854775808 ~ 9223372036854775807
     * @值范围公式 -2^(二进制位数-1) ~ 2^(二进制位数-1)-1，二进制位数：字节数 * 8
     */
    static void intMethod() {
        int i1 = 2_000_000_000; // 加下划线更容易识别
        int i2 = -2_000_000_000;
        int i3 = 0b1000000000; // 二进制表示的512
        int i4 = 0xff0000; // 十六进制表示的16711680

        long n1 = 9000000000000000000L; // long型的结尾需要加L
        long n2 = 900; // 没有加L，此处900为int，但int类型可以赋值给long
        // int i6 = 900L; // 错误:不能把long型赋值给int
    }

    /**
     * 浮点型
     * <p>
     * 浮点类型的数就是小数，因为小数用科学计数法表示的时候，小数点是可以“浮动”的，如1234.5可 以表示成12.345x10^2，也可以表示成1.2345x10^3，所以称为浮点数。
     * <p>
     * @float  字节数4，值范围Float.MIN_VALUE  ~ Float.MAX_VALUE
     * @double 字节数8，值范围Double.MIN_VALUE ~ Double.MAX_VALUE
     */
    static void floatMethod() {
        float f1 = 3.14f;
        float f2 = 3.14e38f; // 科学计数法表示的3.14x10^38
        // float f3 = 1.0; // 错误:不带f结尾的是double类型，不能赋值给float

        double d1 = 1.79e308;
        double d2 = -1.79e308;
        double d3 = 4.9e-324; // 科学计数法表示的4.9x10^-324
    }

    /**
     * 布尔类型
     * <p>
     * 布尔类型 boolean 只有 true 和 false 两个值，默认值为false
     * <p>
     * Java语言对布尔类型的存储并没有做规定，因为理论上存储布尔类型只需要1bit，但是通常JVM内部会把boolean表示为4字节整数。
     */
    static void booleanMethod() {}

    /**
     * 字符类型
     * <p>
     * 字符类型char表示一个字符。Java的char类型除了可表示标准的ASCII外，还可以表示一个Unicode字符
     */
    static void charMethod() {
        char a = 'a';
        char zh = '中';
        System.out.println(a + zh);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="1.2、引用类型">
    /**
     * 引用类型
     * <p>
     * 引用类型的变量类似于C语言的指针，它内部存储一个“地址”，指向某个对象在内存的位置
     */
    static void helloWorld() {
        String s = "惯例：Hello World!";
        System.out.println(s);

        /// 1.2.1、空值null
        /// 引用类型的变量可以指向一个空值 null ，它表示不存在，即该变量不指向任何对象。
        String s1 = null; // s1是null
        String s2 = s1; // s2也是null
        String s3 = ""; // s3指向空字符串，不是null
        // 注意要区分空值 null 和空字符串 "" ，空字符串是一个有效的字符串对象，它不等于 null 。
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="1.3、var关键字">
    /**
     * var关键字
     * <p>
     * 类型的名字太长，写起来比较麻烦，这个时候，如果想省略变量类型，可以使用var关键字。
     */
    static void varMethod() {
        // StringBuilder sb = new StringBuilder();
        // 编译器会根据赋值语句自动推断出变量sb的类型是StringBuilder
        var sb = new StringBuilder();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="2、常量">
    /**
     * 常量
     * <p>
     * 定义变量的时候，如果加上final修饰符，这个变量就变成了常量。为了和变量区分开来，根据习惯，常量名通常全部大写。
     * <p>
     * 常量的作用是用有意义的变量名来避免魔术数字(Magic number)，例如不要在代码中到处写3.14，而是定义一个常量。如果将来需要提高计算精度，我们只需要在常量的定义处修改，例如改成3.1416，而不必在所有地方替换3.14。
     */
    static void finalMethod() {
        // final double PI = 3.14;
        // PI = 3.1416; // compile error!
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3、整数运算">
    /**
     * 整数运算
     * <p>
     * 整数的数值表示不但是精确的，而且整数运算永远是精确的，即使是除法也是精确的，因为两个整数相除只能得到结果的整数部分。
     */
    static void intArithmetic() {
        int x = 12345 / 67; // 184
        System.out.println(x);
        // 求余运算
        int y = 12345 % 67; // 12345÷67的余数是17
        System.out.println(y);
    }

    /**
     * 溢出
     * <p>
     * 整数由于存在范围限制，如果计算结果超出了范围，就会产生溢出，而溢出不会出错 ，却会得到一个奇怪的结果。
     */
    static void arithmeticOverflow() {
        int x = 2147483640;
        int y = 15;
        int sum = x + y;
        /*
          0111 1111 1111 1111 1111 1111 1111 1000
        + 0000 0000 0000 0000 0000 0000 0000 1111
        -----------------------------------------
          1000 0000 0000 0000 0000 0000 0000 0111
         */
        System.out.println(sum); // -2147483641

        double a = 2147483640;
        double b = 15;
        double ab = a + b;
        System.out.println(ab); // 2147483655
    }

    /**
     * 自增、自减
     * <p>
     * 注意 ++ 写在前面和后面计算结果是不同的， ++n 表示先加1再引用n， n++ 表示先引用n再加 1。
     */
    static void simpleArithmetic() {
        // 简写运算符
        int c = 10;
        c += 10; // 20
        System.out.println(c);
        c -= 10; // 10
        System.out.println(c);
        c *= 3;  // 30
        System.out.println(c);
        c /= 15; // 2
        System.out.println(c);

        // 自增、自减
        c = 5;
        c++; // 6
        System.out.println(c);
        c--; // 5
        System.out.println(c);
        ++c; // 6，不建议把 ++ 运算混入到常规运算中，容易自己把自己搞懵了。
        System.out.println(c);
    }

    /**
     * 移位运算
     * <p>
     * 在计算机中，整数总是以二进制的形式表示。
     * <p>
     * 对 byte 和 short 类型进行移位时，会首先转换为 int 再进行位移。
     * <p>
     * 仔细观察可发现，左移实际上就是不断地×2，右移实际上就是不断地÷2。
     */
    static void shiftOperation() {
        int n = 7;      // 00000000 0000000 0000000 00000111
        int a = n << 1; // 0000000 0000000 0000000 000001110 左移1位14
        int b = n >> 1; // 0000000 0000000 0000000 000000011 右移1位3
        System.out.println(a);
        System.out.println(b);

        int c = -536870912; // 11100000 00000000 00000000 00000000
        // 对一个负数进行右移，最高位的 1 不动
        int d = c >> 1;     // 11110000 00000000 00000000 00000000 右移1位
        System.out.println(d);
        int e = c << 1;     // 11000000 00000000 00000000 00000000 左移1位
        // System.out.println(Integer.toBinaryString(e));
        System.out.println(e);

        // 无符号的右移运算，它的特点是不管符号位，右移后高位总是补 0
        int f = c >>> 1;    // 01110000 00000000 00000000 00000000
        System.out.println(f);
    }

    /**
     * 位运算
     * <p>
     * @与(&) 两个数同时为 1 ，结果才为 1
     * @或(|) 任意一个为 1 ，结果就为 1
     * @非(~) 0 和 1 互换
     * @异或(^) 如果两个数不同，结果为 1 ，否则为 0
     */
    static void bitOperation() {
        int i = 167776589; // 00001010 00000000 00010001 01001101 // 10.0.17.77
        int n = 167776512; // 00001010 00000000 00010001 00000000 // 10.0.17.0
                           // & --------------------------------- // 通过&运算，可以快速判断一个IP是否在给定的网段内
                           // 00001010 00000000 00010001 00000000
        int in = i & n;
        System.out.println(in + ", " + Integer.toBinaryString(in));
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.1、运算优先级">
    /**
     * 运算优先级
     * ()
     * !、~、++、--
     * *、/、%
     * +、-
     * >>、<<、>>>
     * &
     * |
     * +=、-=、*=、/=
     */
    static void operationalPriority() {}
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="3.2、类型自动提升与强制转型">
    /**
     * 类型自动提升与强制转型
     * <p>
     * 出范围的强制转型会得到错误的结果，原因是转型时， int 的两个高位字节直接被扔掉，仅保留了低位的两个字节
     */
    static void automaticTypePromotionAndCoercion() {
        short s = 1234;
        int i = 123456;
        // short y = s + i; // 编译错误!
        int x = s + i; // s自动转型为int
        System.out.println(x);

        short si = (short)i; // 将 int 强制转型为 short
        System.out.println(s);

        int i1 = 1234567;
        short s1 = (short) i1; // -10617，错误的结果
        System.out.println(s1);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="4、浮点数运算">
    /**
     * 浮点数运算
     * <p>
     * 只能进行加减乘除这些数值计算，不能做位运算和移位运算。因为浮点数常常无法精确表示，浮点数运算会产生误差。
     * <p>
     * 所以比较两个浮点数是否相等，正确的比较方法是判断两个浮点数之差的绝对值是否小于一个很小的数。
     */
    static void floatCalculation() {
        /// 在计算机中，浮点数虽然表示的范围大，但是，浮点数有个非常重要的特点，就是浮点数常常无法精确表示。
        /// 如浮点数 0.1 在计算机中就无法精确表示，因为十进制的 0.1 换算成二进制是一个无限循环小数，
        /// 很显然，无论使用 float 还是 double ，都只能存储一个 0.1 的近似值。但是 0.5 这个浮点数又可以精确地表示。
        double x = 1.0 / 10;
        double y = 1 - 9.0 / 10;
        // 观察x和y是否相等
        System.out.println(x);
        System.out.println(y);

        /// 4.1、正确判断浮点数是否相等
        double r = Math.abs(x - y);
        if (r < 0.00001) {
            System.out.println("可以认为(x,y)相等");
        } else {
            System.out.println("不相等");
        }

        /// 4.2、类型提升
        int n = 5;
        /// 需要特别注意，在一个复杂的四则运算中，两个整数的运算不会出现自动提升的情况。
        // double d = 1.2 + 24 / n; // 5.2，原因是计算 24/5 这个子表达式时，按两个整数进行运算，结果为整数4 。
        double d = 1.2 + 24.0 / n; // 6.0
        System.out.println(d);

        /// 4.3、溢出
        /// 整数运算在除数为 0 时会报错，而浮点数运算在除数为 0 时，不会报错，但会返回几个特殊值
        double d1 = 0.0 / 0;  // NaN，not a number
        double d2 = 1.0 / 0;  // Infinity，无穷大
        double d3 = -1.0 / 0; // -Infinity，负无穷大
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        /// 4.4、强制转型
        /// 可以将浮点数强制转型为整数。在转型时，浮点数的小数部分会被丢掉。
        int n1 = (int)12.3; // 12
        int n2 = (int)12.7; // 12
        int n3 = (int)-12.7; // -12
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        /// 如果转型后超过了整型能表示的最大范围，将返回整型的最大值。
        int n4 = (int)1.2e20; // 2147483647
        System.out.println(n4 + ", int max value:" + Integer.MAX_VALUE);

        /// 4.4.1、强制转型-四舍五入
        /// 如果要进行四舍五入，可以对浮点数加上 0.5 再强制转型
        double n5 = 2.6;
        double n6 = 2.2;
        int n5Int = (int)(n5 + 0.5); // 3
        int n6Int = (int)(n6 + 0.5); // 2
        System.out.println(n5Int);
        System.out.println(n6Int);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="5、布尔运算">
    /**
     * 布尔运算，是一种关系运算，包括以下几类:
     * @比较运算 >、>=、<、<=、==、!=
     * @与运算 &&
     * @或运算 ||
     * @非运算 !
     * <p>
     * @优先级 ! 大于 (>、>=、<、<=) 大于 (==、!=) 大于 && 大于 ||
     */
    static void boolCalculation() {
        /// 5.1、短路运算
        /// 如果一个布尔运算的表达式能提前确定结果，则后续的计算不再执行，直接返回结果。
        // 因为 false && x 的结果总是 false，无论 x 是 true 还是 false，因此与运算在确定第一个值为 false 后，
        // 不再继续计算，而是直接返回 false。
        boolean b = 5 < 3;
        boolean result = b && (5 / 0 > 0); // 这时候 5 / 0 则不会报错
        System.out.println(result);

        /// 5.2、三元运算符
        // 注意到三元运算 b ? x : y 会首先计算 b，如果 b 为 true ，则只计算 x ，否则只计算 y 。
        // 此外 x 和 y 的类型必须相同，因为返回值不是 boolean ，而是 x 和 y 之一。
        int n = -100;
        int x = n >= 0 ? n : -n; // 100
        System.out.println(x);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="6、字符和字符串">
    /**
     * 字符和字符串，在Java中是不同的类型
     * @char 是基本数据类型，一个 char 保存一个Unicode字符
     * @String 是引用类型
     */
    static void charAndString() {
        // 因为Java在内存中总是使用Unicode表示字符，所以一个英文字符和一个中文字符都用一个 char 类型表示，
        // 它们都占用两个字节。要显示一个字符的Unicode编码，只需将 char 类型直接赋值给 int 类型即可
        int n1 = 'A'; // 字母“A”的Unicodde编码是65
        int n2 = '中'; // 汉字“中”的Unicode编码是20013
        System.out.println(n1);
        System.out.println(n2);
        // 还可以直接用转义字符 \\u+Unicode编码(16进制) 来表示一个字符:
        char c3 = '\u0041'; // 'A'，因为十六进制0041 = 十进制65
        char c4 = '\u4e2d'; // '中'，因为十六进制4e2d = 十进制20013
        System.out.println(c3);
        System.out.println(c4);

        /// 6.1、字符串
        ///      常见的转义字符：
        ///      \" 表示字符 "
        ///      \' 表示字符 '
        ///      \\ 表示字符 \
        ///      \n 表示换行符
        ///      \r 表示回车符
        ///      \t 表示Tab
        ///      \\u#### 表示一个Unicode编码的字符
        String s = ""; // 空字符串，包含0个字符
        String s1 = "A"; // 包含一个字符
        String s2 = "中文 ABC"; // 包含6个字符，其中有一个空格
        String s3 = "ABC\n\u0041\u4e2d"; // 包含6个字符: ABC换行符A中
        System.out.println(s3);

        /// 6.2、字符串连接
        ///      可以使用 + 连接任意字符串和其他数据类型
        ///      如果用 + 连接字符串和其他数据类型，会将其他数据类型先自动转型为字符串，再连接
        int age = 25;
        String s4 = "age is " + age;
        System.out.println(s4); // age is 25

        /// 6.3、多行字符串
        // 我们要表示多行字符串，使用+号连接会非常不方便:
        String s5 = "first line \n"
                + "second line \n"
                + "end";
        System.out.println(s5);
        // 从Java 13开始，字符串可以用 """...""" 表示多行字符串(Text Blocks)了
        s5 = """
                SELECT * FROM users
                WHERE id > 100
                ORDER BY name DESC-A
                """;
        // 上述多行字符串实际上是5行，在最后一个 DESC 后面还有一个 \n
        System.out.println(s5);
        s5 = """
                SELECT * FROM users
        WHERE id > 100
                ORDER BY name DESC-B""";
        // 如果多行字符串的排版不规则，总是以最短的行首空格为基准
        System.out.println(s5);

        /// 6.4、字符串不可变
        String str = "Hello";
        System.out.println(str); // Hello
        str = "World";
        System.out.println(str); // World
        // 观察上面的执行结果， str 字符串并没有变，变得是 str 的指向
        // 执行 String str = "Hello"; 时，JVM虚拟机先创建字符串 "Hello"，然后把字符串变量 str 指向它
        // 紧接着，执行 str = "World"; 时，JVM虚拟机先创建字符串 "World" ，然后把字符串变量 str 指向它
        // 原来的字符串 "Hello" 还在，只是我们无法通过变量 str 访问它而已。
        // 因此，字符串的不可变是指字符串内容不可变。至于变量，可以一会指向字符串 "Hello" ，一会指向字符串 "World" 。
        String str1 = "hello";
        String t = str1;
        str1 = "world";
        System.out.println(t); // t是"hello"还是"world"?
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="7、数组类型">
    /// 数组类型(类型[]，如 int[])
    ///
    /// @特点1 数组所有元素初始化为默认值，整型都是 0 ，浮点型是 0.0 ，布尔型是 false
    /// @特点2 数组是引用类型，一旦创建后，大小就不可改变
    /// @特点3 要访问数组中的某一个元素，需要使用索引，数组索引从 0 开始。
    static void arrayMethod() {
        /*
        int[] ns = new int[5];
        ns[0] = 68;
        ns[1] = 79;
        ns[2] = 91;
        ns[3] = 85;
        ns[4] = 62;
        */
        // int[] ns = new int[] { 68, 79, 91, 85, 62};
        int[] ns;
        ns = new int[] { 68, 79, 91, 85, 62 };
        System.out.println(ns.length); // 5
        ns = new int[] { 1, 2, 3 };
        System.out.println(ns.length); // 3
        // 数组大小变了吗?看上去好像是变了，但其实根本没变。
        // 对于变量 ns 来说，程序先创建了 { 68, 79, 91, 85, 62 } 这个数组，然后由 ns 去指向这个数组
        // 执行 ns = new int[] { 1, 2, 3 }; 时，ns 指向一个新的数组，原数组并没有改变
    }

    /**
     * 7.1、字符串数组
     */
    static void stringArrayMethod() {
        String[] names = { "ABC", "XYZ", "zoo" };
        String s = names[1];
        // 原来 names[1] 指向的字符串 "XYZ" 并没有改变，仅仅是将 向 "XYZ" 改成了指向 "cat"；
        // 其结果是字符串 "XYZ" 再也无法通过 names[1] 访问到了
        names[1] = "cat";
        System.out.println(s); // s是"XYZ"还是"cat"?
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="8、输入和输出">
    /**
     * 输出
     */
    static void printMethon() {
        System.out.println("START"); // print line
        System.out.print("A,");
        System.out.print("B");
    }

    /// 8.1、格式化输出
    ///
    /// [常用占位符，更多格式化参数参考官网链接](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Formatter.html#syntax)：
    /// @%d 格式化输出整数
    /// @%x 格式化输出十六进制整数
    /// @%f 格式化输出浮点数
    /// @%e 格式化输出科学计数法表示的浮点数
    /// @%s 格式化字符串
    static void printfMethon() {
        double d = 3.1415926;
        System.out.printf("%.2f\n", d);
        System.out.printf("%.4f\n", d);

        int n = 12345000;
        System.out.printf("n=%d, hex=%08x", n, n); // 两个%占位符必须传入两个数
    }

    /**
     * 8.2、输入
     */
    static void inputMethod() {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.print("Input your name: ");    // 打印提示
        String name = scanner.nextLine();         // 读取一行输入并获取字符串
        System.out.print("Input your age: ");
        int age = scanner.nextInt();              // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="9、if条件语句">
    static void ifMethod() {
        /// 9.1 if 条件判断
        int n = 70;
        if (n < 60)
            System.out.println("不及格"); // 只有一行语句时，可以省略花括号{}
        // 但是，省略花括号并不总是一个好主意。假设某个时候，突然想给 if 语句块增加一条语句时
        // 由于使用缩进格式，很容易把两行语句都看成 if 语句的执行块
        /// 在使用git这些版本控制系统自动合并时更容易出问题，所以不推荐忽略花括号的写法。
            System.out.println("要加油"); // 注意这条语句不是if语句块的一部分

        if (n >= 90) {
            System.out.println("优秀");
        } else if (n >= 60) {
            System.out.println("及格了");
            /*
            串联，相当于：
            if (n >= 90) {
               System.out.println("优秀");
            } else {
               if (n >= 60) {
               } else {
               }
            }
             */
        } else {
            System.out.println("挂科了");
        }
        System.out.println("END");

        /// 9.2 在串联使用多个 if 时，要特别注意判断顺序
        // 正确的方式是 > 按照判断范围从大到小，< 从小到大依次判断
        n = 100;
        if (n >= 60) {
            System.out.println("及格了"); // 先判断 n >= 60 成功后，后续 else 不再执行了。
        } else if (n >= 90) {
            System.out.println("优秀");
        } else {
            System.out.println("挂科了");
        }

        /// 9.3 使用 if 判断，要注意边界条件
        // 前面讲过了浮点数在计算机中常常无法精确表示，并且计算可能出现误差，因此判断浮点数相等用 == 判断不靠谱
        double x = 1 - 9.0 / 10;
        // if (x == 0.1) {
        if (Math.abs(x - 0.1) < 0.00001) {
            System.out.println("x is 0.1");
        } else {
            System.out.println("x is NOT 0.1");
        }

        /// 9.4 判断引用类型相等，使用 equal() 方法
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        /*
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2"); // false
        }
        */
        s1 = null;
        // if (s1.equals(s2)) { // 如果此时 s1 为 null，会报 NullPointerException
        // 要避免这个问题，可以使用短路运算符 &&
        if (s1 != null && s1.equals(s2)) {
            System.out.println("s1 等于 s2");
        } else {
            System.out.println("s1 不等于 s2");
        }
        // 还可以把一定不是 null 的对象 放到前面: if ("he".equals(s1))
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="10、switch条件语句">
    /**
     * switch条件语句
     * @case case语句没有花括号{}，而且case语句具有穿透性，漏写break将导致意想不到的结果
     */
    static void switchMethod() {
        int option = 2;
        switch (option) {
            case 1:
                System.out.println("Selected 1");
                break;
            case 2:
                System.out.println("Selected 2");
                // break;
            case 3:
            case 4:
                System.out.println("Selected 3、4");
                break;
            default:
                System.out.println("Selected other");
                break;
        }
        /// 使用 switch 语句时，只要保证有 break ， case 的顺序不影响程序逻辑
        /// 但是仍然建议按照自然顺序排列，便于阅读。
        switch (option) {
            case 1:
                System.out.println("Selected 1");
                break;
            case 3:
                System.out.println("Selected 3");
                break;
            case 2:
                System.out.println("Selected 2");
                break;
            default:
                System.out.println("Selected other");
                break;
        }

        /// 10.1、字符串匹配时，是比较“内容相等”
        String fruit = "apple";
        switch (fruit) {
            case "apple":
                System.out.println("Selected apple");
                break;
            case "pear":
                System.out.println("Selected pear");
                break;
            case "mango":
                System.out.println("Selected mango");
                break;
            default:
                System.out.println("No fruit selected");
                break;
        }

        /// 10.2、Java 12开始，switch 升级，类似模式匹配
        ///       保证只有一种路径会被执行，并且不需要 break 语句
        switch (fruit) {
            case "apple" -> System.out.println("(Java12)Selected apple");
            case "pear" -> {
                System.out.println("(Java12)Selected pear");
            }
            case "mango" -> System.out.println("(Java12)Selected mango");
            default -> System.out.println("(Java12)No fruit selected");
        }
        ///       还可以直接返回值
        int opt = switch (fruit) {
            case "apple" -> 1;
            case "pear", "mango" -> {
                yield 2;
            }
            default -> 0;
        }; // 注意赋值语句要以;结束
        System.out.println("opt = " + opt);
    }
    // </editor-fold>\

    // <editor-fold defaultstate="collapsed" desc="11、while循环，do-while循环">
    /**
     * while循环，先判断条件，再执行循环
     */
    static void whileMethod() {
        int sum = 0;
        int n = 1;
        while (n <= 100) {
            sum += n;
            n ++;
        }
        System.out.println(sum);

        ///  11.1、死循环
        // 如果循环条件永远满足，那这个循环就变成了死循环。死循环将导致100%的CPU占用，用户会感觉 电脑运行缓慢
        // 表面上看下面的 while 循环是一个死循环，但是Java的 int 类型有最大值，达到最大值后，再加1会变成负数，结果意外退出了 while 循环
        while (n > 0) {
            sum = sum + n;
            n ++;
        }
        System.out.println(n); // -2147483648
    }

    /**
     * 11.2、do-while循环
     * <p>先执行循环，再判断条件，条件满足时继续循环，条件不满足时退出。
     * <p>可见，do-while循环至少循环一次
     */
    static void doWhileMethod() {
        int sum = 0;
        int n = 1;
        do {
            sum = sum + n;
            n ++;
        } while (n <= 100); // 一样要注意死循环
        System.out.println(sum);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="12、for循环，for-each循环">
    /**
     * for循环，Java使用的最广的循环
     * <p>会先初始化计数器，然后在每次循环前检测循环条件，在每次循环后更新计数器。
     */
    static void forMethod() {
        int[] ns = { 1, 4, 9, 16, 25 };
        int sum = 0;
        /// 使用 for 循环时，千万不要在循环体内修改计数器! 在循环体中修改计数器常常导致莫名其妙的逻辑错误。
        for (int i=0; i<ns.length; /* i++ */ i=i+2) {
            sum = sum + ns[i];
            // i = i + 1; // 如果希望只访问索引号为偶数的数组元素，应该把 for 循环改写
        }
        System.out.println(sum);

        /// 12.1、变量 i 不要定义在 for 循环外
        int i;
        for (i=0; i<ns.length; i++) {
            System.out.println(ns[i]);
        }
        int iNew = i; // 仍然可以使用i
        // 退出 for 循环后，变量 i 仍然可以被访问，这就破坏了变量应该把访问范围缩到最小的原则。

        /// 12.2 灵活使用for循环
        ///      通常不推荐这样写，但是某些情况下，是可以省略 for 循环的某些语句的。
        // 不设置结束条件:
//        for (int n=0; ; n++) {} // 死循环
        // 不设置结束条件和更新语句:
//         for (int n=0;;) {} // 死循环
        // 什么都不设置:
//        for (;;) {} // 死循环

        /// 12.3 for-each循环，它可以更简单地遍历数组
        for (int n : ns) {
            System.out.println(n);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="13、break和continue">
    /**
     * 循环中的break和continue
     */
    static void breakAndContinue() {
        /// 13.1、break，跳出当前循环
        int sum = 0;
        for (int i=1; ; i++) { // 死循环
            sum = sum + i;
            if (i == 100) {
                break;
            }
        }
        System.out.println(sum);

//        for (int i=1; i<=10; i++) {
//            System.out.println("i = " + i);
//            for (int j=1; j<=10; j++) {
//                System.out.println("j = " + j);
//                if (j >= i) {
//                    break;
//                }
//            }
//            // break跳到这里，但不会跳出外层 for 循环。
//            System.out.println("breaked");
//        }

        /// 13.2、continue，提前结束本次循环，直接继续执行下次循环
        ///       在多层嵌套的循环中， continue 语句同样是结束本次自己所在的循环。
        sum = 0;
        for (int i=1; i<=10; i++) {
            System.out.println("begin i = " + i);
            if (i % 2 == 0) {
                continue;
            }
            sum = sum + i;
            System.out.println("end i = " + i);
        }
        System.out.println(sum);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="14、冒泡排序">
    /**
     * 冒泡排序
     */
    static void arrayForEach() {
        /// 14.1、冒泡排序
        ///       冒泡排序的特点是，每一轮循环后，最大的一个数被交换到末尾，因此下一轮循环就可以“刨除”最后的数，
        ///       每一轮循环都比上一轮循环的结束位置靠前一位。
        int[] ns = { 6, 5, 4, 3 };
        System.out.println(Arrays.toString(ns)); // 排序前
//        for (int i = 0; i < ns.length - 1; i++) {
//            System.out.println("外层for: " + i);
//            for (int j = 0; j < ns.length - i - 1; j++) {
//                if (ns[j] > ns[j+1]) {
//                    // 交换 ns[j] 和 ns[j+1]
//                    int tmp = ns[j];
//                    ns[j] = ns[j+1];
//                    ns[j+1] = tmp;
//                }
//                System.out.println("内层for: " + j + ", " + Arrays.toString(ns));
//            }
//        }
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns)); // 升序排序后
        /// 必须注意，对整型数组排序实际上修改了数组本身，ns 指向的数组内容已经完全变了
        /// 在内存中 ns -> [6|5|4|3] 排序后中变为 ns -> [3|4|5|6]
        /// 但是
        /// 对字符串数组进行排序
        /// String[] nStr = { "banana", "apple", "pear" };
        /// Arrays.sort(nStr); // { "apple", "banana", "pear" }
        /// 在内存中 nStr -> ["banana"|"apple"|"pear"] 排序后中还是 nStr -> ["banana"|"apple"|"pear"]
        /// 但是 nStr 数组的每个元素指向变化了

        int[] ns1 = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 }; // 排序前:
        System.out.println(Arrays.toString(ns1));
        boolean hasSwap; // 标记本轮是否发生交换（优化点）
        // 外层循环：控制排序轮数（最多需要n-1轮）
        // 原理：数组有n个元素，最多需要n-1轮排序（例如：2 个元素只需 1 轮，3 个元素最多 2 轮）；
        //      每轮将未排序的最大元素放到末尾，已排序元素无需再比较
        // 变量i的含义：表示已完成排序的元素个数（每轮结束后，末尾多 1 个有序元素）
        for (int i = 0; i < ns1.length - 1; i++) {
            hasSwap = false; // 初始化：本轮未发生交换
            // 内层循环：核心比较与交换
            // 原理：每轮只需遍历未排序的前半部分（末尾i个元素已有序，无需比较）；
            // 变量j的含义：遍历未排序部分的索引，每次比较arr[j]和arr[j+1]；
            for (int j = 0; j < ns1.length - i - 1; j++) {
                if (ns1[j] < ns1[j+1]) {
                    int tmp = ns1[j];
                    ns1[j] = ns1[j+1];
                    ns1[j+1] = tmp;
                    hasSwap = true; // 标记本轮发生了交换
                }
            }
            if (!hasSwap) {
                // 优化：若本轮无交换，说明数组已完全有序，直接退出循环
                // 场景：若某一轮遍历中没有发生任何交换，说明数组已完全有序（例如：数组[8,12,18,28,36,50,65,73,89,96]）；
                // 作用：避免后续不必要的轮次，将最佳时间复杂度从O(n²)优化到O(n)（数组已有序时）。
                break;
            }
        }
        System.out.println(Arrays.toString(ns1)); // 降序排序后
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="15、多维数组">
    /**
     * 多维数组
     */
    static void multidimensionalArray() {
        /// 15.1、二维数组
        ///       每个数组元素的长度并不要求相同
        int[][] ns = {
                { 1, 2, 3, 4},
                { 5, 6, 7 },
                { 9, 10, 11, 12 }
        };
        System.out.println(ns[1][2]); // 7
        System.out.println(Arrays.deepToString(ns));
        int[] arr0 = ns[0];
        System.out.println(Arrays.toString(arr0));

        /// 15.2 三维数组
        // 理论上，我们可以定义任意的N维数组。但在实际应用中，除了二维数组在某些时候还能用得上，更 高维度的数组很少使用。
//        int[][][] ns3 = {
//                {
//                        {1, 2, 3},
//                        {4, 5, 6},
//                        {7, 8, 9}
//                },
//                {
//                        {10, 11},
//                        {12, 13}
//                },
//                {
//                        {14, 15, 16},
//                        {17, 18}
//                }
//        };
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="16、命令行参数">
    static void commandLineParameters(String[] args) {
        // 这个命令行参数由JVM接收用户输入并传给 main 方法
        // 必须在命令行中执行，先编译
        // javac Hello.java
        // 执行的时候，给它传递一个 -version 参数
        // java Hello.java -version
        for (String arg : args) {
            if ("-version".equals(arg)) {
                 System.out.println("v 1.0");
            }
        }
    }
    // </editor-fold>
}

// <editor-fold defaultstate="collapsed" desc="17、class、instance和构造方法">
/**
 * class 是一种对象模版，它定义了如何创建实例，因此，class本身就是一种数据类型
 * <p>instance是对象实例，instance是根据class创建的实例，可以创建多个instance，每个instance 类型相同，但各自属性可能不相同
 */
class Person {
    /// 字段(field) name，字段用来描述一个类的特征
    protected String name = "Unamed"; // 未初始化时引用类型默认初始化为 null
    protected int age = 13; // 未初始化时基本类型使用默认值

    /**
     * 17.1、构造方法，如果我们自定义了一个构造方法，那么编译器就不再自动创建默认构造方法
     * <p>和普通方法相比，构造方法的名称就是类名，且没有返回值(也没有 void )
     * <p>调用构造方法，必须用 new 操作符
     */
    public Person(String name, int age) {
        /*
        前面我们并没有为 Person 类编写构造方法，为什么可以调用 new Person()

        原因是如果一个类没有定义构造方法，编译器会自动为我们生成一个默认构造方法，它没有参数，也没有执行语句，类似这样:
        class Person {
           public Person() {
           }
        }
         */
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        // 多个构造方法
        this(name, 18); // 调用另一个构造方法Person(String, int)
    }

    /**
     * 17.2、还想保留不带参数的构造方法
     */
    public Person() {
        this("Li"); // 调用另一个构造方法Person(String)
    }

    /// get方法
    public String getName() {
        return name; // 相当于this.name
    }
    /// set方法
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("invalid name");
        }
        /// 隐含的变量 this ，它始终指向当前实例。
        this.name = name.strip();
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

    static void func() {
        /// 17.3、创建对象初始化顺序
        /// 创建一个Person类型的实例，并通过变量 ming 指向它
        ///
        /// 问题：既对字段进行初始化，又在构造方法中对字段进行初始化，字段的初始值是啥？
        ///
        /// 在Java中，创建对象实例的时候，按照如下顺序进行初始化:
        /// 1. 先初始化字段，例如 int age = 13; 表示字段初始化为 13；
        /// 2. 执行构造方法的代码进行初始化；
        Person ming = new Person("Xiao Ming", 12);
        System.out.println(ming.age);
        Person fan = new Person("Fan");
        System.out.println(fan.age);
    }
}
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="18、可变参数">

class Group {
    private String[] names;

    /**
     * 可变参数
     * <p>可变参数用 类型... 定义，可变参数相当于数组类型
     */
    public void setNames(String... names) {
        this.names = names;
    }

    /**
     * 为什么不把可变参数改写为 String[] 类型
     */
    public void setNamesArray(String[] names) {
        this.names = names;
    }
    static void func() {
        Group group = new Group();
        /// 1、调用方需要自己先构造 String[]，比较麻烦。
        group.setNamesArray(new String[] { "Xiao Ming", "Xiao Hong", "Xiao Jun" });
        /// 2、调用方可以传入 null
        group.setNamesArray(null);
        /// 3、而可变参数可以保证无法传入 null ，因为传入0个参数时，接收到的实际值是一个空数组而不是 null
        group.setNames(null);
    }
}
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="19、参数绑定">

class PersonParamBind {
    private int age;
    private String[] fullname;

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getFullname() {
        return this.fullname[0] + " " + this.fullname[1];
    }
    public void setFullname(String[] fullname) {
        this.fullname = fullname;
    }

    static void func() {
        PersonParamBind p = new PersonParamBind();
        int n = 15;
        p.setAge(n);
        System.out.println(p.age);
        n = 20;
        /// 19.1、基本类型参数绑定
        ///       基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。
        System.out.println(p.age); // 15

        String[] fullname = { "Liu", "Fan" };
        p.setFullname(fullname);
        System.out.println(p.getFullname()); // "Liu Fan"
//        fullname = new String[] {"laz", "ss"}; // fullname 指向了新的数组，但是p.fullname指向还是原数组
//        System.out.println(p.getFullname()); // "Liu Fan"
        /// 19.2、引用类型参数绑定
        ///       引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。
        ///       双方任一方对这个对象的修改，都会影响对方(因为指向同一个对象嘛)。
        fullname[0] = "Lau";
        System.out.println(p.getFullname()); // "Lau Fan"
    }
}
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="20、方法重载">

class MethodOverload {
    /// 在一个类中，我们可以定义多个方法。如果有一系列方法，它们的功能都是类似的，只有参数有所不同，
    /// 那么，可以把这一组方法名做成同名方法。
    ///
    /// 这种方法名相同，但各自的参数不同，称为方法重载( Overload )
    ///
    /// 方法重载的目的是，功能类似的方法使用同一名字，更容易记住，因此，调用起来更简单。
    ///
    /// 注意:方法重载的返回值类型通常都是相同的。
    public void hello() {
        System.out.println("Hello, world!");
    }
    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }
    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
}

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="21、继承">

class Person1 {
    protected String name;
    protected int age;
    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

/**
 * 继承
 * <p>子类(扩展类)自动获得了父类(超类、基类)的所有字段，严禁定义与父类重名的字段!
 */
class Student extends Person1 {
    /// 继承有个特点，就是子类无法访问父类的 private 字段或者 private 方法。
    ///
    /// 用 protected 修饰的字段可以被子类访问。
    protected int score; // 严禁定义与父类重名的字段!

    public Student(String name, int age, int score) {
        /// 如果父类没有默认的构造方法，子类就必须显式调用 super() 并给出参数以便让编译器定位到父类的一个合适的构造方法。
        /// 这里还顺带引出了另一个问题:即子类 不会继承 任何父类的构造方法。子类默认的构造方法是编译 器自动生成的，不是继承的。
        super(name, age);
        this.score = score;
    }

    public String hello() {
        /// super 关键字表示父类(超类)。子类引用父类的字段时，可以用 super.fieldName
        return "Hello, " + super.name;
    }

    static void func() {
        Student s = new Student("a", 10, 100);
        System.out.println(s.name);
    }
}
// </editor-fold>

/// 阻止继承