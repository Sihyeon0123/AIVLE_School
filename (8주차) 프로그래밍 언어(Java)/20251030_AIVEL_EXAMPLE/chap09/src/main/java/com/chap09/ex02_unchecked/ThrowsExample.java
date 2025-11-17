package com.chap09.ex02_unchecked;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsExample {

    // throws 키워드를 사용해 IOException을 던질 수 있음을 명시
    public void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close(); // 파일 읽기를 마친 후, 리소스를 해제함
    }

    public static void main(String[] args) {
        ThrowsExample example = new ThrowsExample();
        try {
            example.readFile("example2.txt");
        } catch (java.io.IOException e) {
            // 예외 처리: 파일을 찾을 수 없거나 읽을 수 없을 때 발생
            System.err.println("파일을 처리하는 도중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
