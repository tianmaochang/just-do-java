package com.now;

public class SubClass extends SuperClass {
    /**
     * 说明：子类在覆盖父类的方法时，子类所声明异常的级别不能大于父类声明的异常级别。
     */
//    public void start() throws Exception{}

    public void foo() throws RuntimeException{}
}
