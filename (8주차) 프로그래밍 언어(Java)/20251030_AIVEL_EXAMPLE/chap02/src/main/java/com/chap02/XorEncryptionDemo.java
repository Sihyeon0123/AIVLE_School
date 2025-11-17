package com.chap02;

public class XorEncryptionDemo {
    public static void main(String[] args) {
        int originalPassword = 123456; // 원본 비밀번호
        int encryptedPassword; // 암호화된 비밀번호
        int key = 0x1A253B65; // 암호화/복호화 키

        System.out.println("암호화전 비밀번호 : " + originalPassword);
        // 비밀번호 암호화: 원본 비밀번호와 키를 XOR 연산
        encryptedPassword = originalPassword ^ key;
        System.out.println("암호화된 비밀번호 : " + encryptedPassword);

        // 비밀번호 복호화: 암호화된 비밀번호와 동일한 키를 XOR 연산
        int decryptedPassword = encryptedPassword ^ key;
        System.out.println("복호화된 비밀번호 : " + decryptedPassword);
    }
}
