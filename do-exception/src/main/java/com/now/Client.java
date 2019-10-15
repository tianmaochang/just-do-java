package com.now;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
* 测试类
*/
public class Client {
    public static void main(String[] args) {
        try {
            testExceptions();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testExceptions() throws IOException,FileNotFoundException {

    }
}
