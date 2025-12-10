package com.chap09.ex01_checked;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@SuppressWarnings("unused")
public class MalformedURLExceptionExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("URL 입력해 주세요 : ");
            String strUrl = sc.nextLine();
            try {
                URL url = new URL(strUrl);
            } catch (MalformedURLException e) {
                System.out.println("잘못된 URL 형식입니다: " + e.getMessage());
                continue;
            }
            System.out.println( strUrl + " 입력한 URL은 유효합니다.");
            sc.close();
        }
    }
}
