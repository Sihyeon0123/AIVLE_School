package com.chap08.ex01_generics;
import java.util.Map;

class MultiTypeGeneric<K,V> implements Map.Entry<K,V>{
    private K key;
    private V value;
    public MultiTypeGeneric(K key, V value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public K getKey() {
        return this.key;
    }
    @Override
    public V getValue() {
        return this.value;
    }
    @Override
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}

public class MultiTypeGenericMain {
    public static void main(String[] args) {
        MultiTypeGeneric<String, Integer> multiTypePair =
                new MultiTypeGeneric<>("one",1);

        multiTypePair.setValue(2);
        String key = multiTypePair.getKey();
        Integer value = multiTypePair.getValue();
        System.out.println("키: " + key + ", 값: " + value); // 출력: 키: one, 값: 1

        MultiTypeGeneric<Double, String> multiTypePair2 =
                new MultiTypeGeneric<>(0.2,"hello");

        Double key2 = multiTypePair2.getKey();
        String value2 = multiTypePair2.getValue();
        System.out.println("키: " + key2 + ", 값: " + value2); // 출력: 키: one, 값: 1
    }
}
