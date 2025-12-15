package com.example.helloworld;

/*
数据类通常需要重写equals()、hashCode()、toString()这几个方法。

equals()方法用于判断两个数据类是否相等。
hashCode()方法作为equals()的配套方法，也需要一起重写，否则会导致HashMap、HashSet等hash相关的系统类无法正常工作。
toString()方法用于提供更清晰的输入日志，否则一个数据类默认打印出来的就是一行内存地址。
 */
class CellphoneJava {
    String brand;
    double price;

    public CellphoneJava(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CellphoneJava) {
            CellphoneJava other = (CellphoneJava) obj;
            return other.brand.equals(brand) && other.price == price;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return brand.hashCode() + (int) price;
    }

    @Override
    public String toString() {
        return "CellphoneJava(brand=" + brand + ", price=" + price + ")";
    }
}
