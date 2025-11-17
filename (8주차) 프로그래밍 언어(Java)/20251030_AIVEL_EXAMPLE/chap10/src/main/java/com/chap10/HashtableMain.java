package com.chap10;

import java.util.Hashtable;
import java.util.Map;

public class HashtableMain {
    public static void main(String[] args) {
        Map<String,Integer> hashtable = new Hashtable<>();
        hashtable.put("사과", 10);
        hashtable.put("바나나", 5);
        hashtable.put("체리", 20);

        try {
            hashtable.put("딸기", 5);
            hashtable.put("오렌지", null);
        }catch (NullPointerException e){
            System.out.println("Hashtable은 null 키와 값을 허용하지 않습니다.");
        }
        System.out.println(hashtable);

        System.out.println("사과의 수량: " + hashtable.get("사과"));
        hashtable.remove("바나나");

        System.out.println("현재 Hashtable:");
        for (Map.Entry<String, Integer> entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("체리가 존재하는가? " + hashtable.containsKey("체리"));
        System.out.println("체리가 존재하는가? " + hashtable.containsValue(1));

        System.out.println("총 요소 수: " + hashtable.size());
        hashtable.clear();
    }
}
