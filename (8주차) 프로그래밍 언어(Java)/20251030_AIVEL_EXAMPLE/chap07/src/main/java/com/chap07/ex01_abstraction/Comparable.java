package com.chap07.ex01_abstraction;

// 추상 메서드만 가지는 구조
// 인스터스 멤버를 못 가짐
public interface Comparable<T> {
    int compareTo(T o);
}
