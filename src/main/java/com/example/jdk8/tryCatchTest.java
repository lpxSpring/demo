package com.example.jdk8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;

/**
 * @author 18124550
 * @date 2019/10/25
 */
public class tryCatchTest {

    public static void main(String[] args) throws IOException {
        test("");

    }

    // 自动关闭out流
    private static void test(String filePath) throws IOException {
        OutputStream out = new FileOutputStream(filePath);
        try (OutputStream out1 = out){
        } catch (Exception e) {
            out.write("Java是世界上最好的语言！".getBytes());
            e.printStackTrace();
        }

    }
}
