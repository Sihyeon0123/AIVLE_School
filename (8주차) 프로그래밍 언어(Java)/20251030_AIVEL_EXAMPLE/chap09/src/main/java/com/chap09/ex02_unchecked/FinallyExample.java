package com.chap09.ex02_unchecked;

import java.io.FileInputStream;
import java.io.IOException;

public class FinallyExample {
    public static void main(String[] args) {
        FileInputStream file = null;
        try {
            file = new FileInputStream("example.txt");
            int content;
            while ((content = file.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 중 예외 발생: " + e.getMessage());
        } finally {
            if (file != null) {
                try {
                    file.close();
                    System.out.println("\n파일이 성공적으로 닫혔습니다.");
                } catch (IOException e) {
                    System.out.println("파일 닫기 실패: " + e.getMessage());
                }
            }
        }
    }
}
