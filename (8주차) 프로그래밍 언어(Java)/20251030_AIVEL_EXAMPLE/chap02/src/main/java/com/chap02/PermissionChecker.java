package com.chap02;

public class PermissionChecker {
    public static void main(String[] args) {
        // 각 권한을 나타내는 비트 마스크
        int readPermission = 0x01;  // 읽기 권한 (이진수: 0001)
        int writePermission = 0x02; // 쓰기 권한 (이진수: 0010)
        int executePermission = 0x04; // 실행 권한 (이진수: 0100)
        int userPermission = 0; // 사용자 권한 초기화 (이진수: 0000)

        // 읽기 권한 추가 (이진수: 0000 | 0001  = 0001)
        userPermission = userPermission | readPermission;
        System.out.printf("읽기 권한 추가 후: 0x%02x (이진수: %04d)\n", userPermission, Integer.parseInt(Integer.toBinaryString(userPermission)));

        // 쓰기 권한 추가 (이진수: 0001 | 0010 = 0011)
        userPermission = userPermission | writePermission;
        System.out.printf("쓰기 권한 추가 후: 0x%02x (이진수: %04d)\n", userPermission, Integer.parseInt(Integer.toBinaryString(userPermission)));

        // 실행 권한 추가 (이진수: 0011 | 0100 = 0111)
        userPermission = userPermission | executePermission;
        System.out.printf("실행 권한 추가 후: 0x%02x (이진수: %04d)\n", userPermission, Integer.parseInt(Integer.toBinaryString(userPermission)));

        // 읽기 권한 확인 (이진수: 0111 & 1111 = 0001)
        int checkRead = userPermission & readPermission;
        System.out.printf("읽기 권한 확인: 0x%02x (이진수: %04d)\n", checkRead, Integer.parseInt(Integer.toBinaryString(checkRead)));

        // 쓰기 권한 확인 (이진수: 0111 & 0010 = 0010)
        int checkWrite = userPermission & writePermission;
        System.out.printf("쓰기 권한 확인: 0x%02x (이진수: %04d)\n", checkWrite, Integer.parseInt(Integer.toBinaryString(checkWrite)));

        // 실행 권한 확인 (이진수: 0111 & 0100 = 0100)
        int checkExecute = userPermission & executePermission;
        System.out.printf("실행 권한 확인: 0x%02x (이진수: %04d)\n", checkExecute, Integer.parseInt(Integer.toBinaryString(checkExecute)));

        // 읽기 권한 삭제 (이진수: 0111 & 1110 = 0110)
        userPermission = userPermission & ~readPermission;
        System.out.printf("읽기 권한 삭제 후: 0x%02x (이진수: %04d)\n", userPermission, Integer.parseInt(Integer.toBinaryString(userPermission)));

        // 쓰기 권한 삭제 (이진수: 0110 & 1101 = 0100)
        userPermission = userPermission & ~writePermission;
        System.out.printf("쓰기 권한 삭제 후: 0x%02x (이진수: %04d)\n", userPermission, Integer.parseInt(Integer.toBinaryString(userPermission)));

        // 실행 권한 삭제 (이진수: 0110 & 1011 = 0100)
        userPermission = userPermission & ~executePermission;
        System.out.printf("실행 권한 삭제 후: 0x%02x (이진수: %04d)\n", userPermission, Integer.parseInt(Integer.toBinaryString(userPermission)));

    }
}
