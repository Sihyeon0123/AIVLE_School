package com.chap04;

public class EnhForDemo {
    public static void main(String[] args) {
        // 배열 선언 및 초기화
        int[] nums = {1, 2, 3, 4, 5};
        // 확장된 for 문을 사용하여 배열의 각 요소 출력
        System.out.println("원본 배열:");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println(); // 줄바꿈
        // 배열의 각 요소를 수정하려면 전통적인 for 문을 사용해야 함
        System.out.println("각 요소에 10을 더한 결과:");
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 10; // 각 요소에 10 더하기
            System.out.print(nums[i] + " ");
        }
        System.out.println(); // 줄바꿈
        // 확장된 for 문을 사용하여 배열 요소의 합 계산
        int sum = 0;
        for (int n : nums) {
            // 11, 12, 13, 14, 15
            sum += n; // 합계에 각 요소 추가
        }
        // 총합 출력
        System.out.println("수정된 배열의 요소 합계: " + sum);
    }
}