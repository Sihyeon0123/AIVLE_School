package com.chap08.ex01_generics;

@SuppressWarnings("unused")
public class GenericMethod {
    public static <T, V> boolean compare(People<T, V> person1, People<T, V> person2){
        boolean nameCompare = person1.getName().equals(person2.getName());
        boolean ageCompare = person1.getAge().equals(person2.getAge());
        // person1.getAge() -> Integer 클래스 맴버로 equals
        return nameCompare && ageCompare;
    }
    public static class People<T,V>{
        private T name;
        private V age;
        public People(T name, V age) {
            this.name = name;
            this.age = age;
        }

        public T getName() {
            return name;
        }

        public V getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Double db;
        Byte by;
        Float f;

        People<String, Integer> person1 = new People<>("John", 30);
        People<String, Integer> person2 = new People<>("John", 30);
        boolean isSame = compare(person1, person2);
        System.out.println("두 사람은 같은가? " + isSame);
    }
}
