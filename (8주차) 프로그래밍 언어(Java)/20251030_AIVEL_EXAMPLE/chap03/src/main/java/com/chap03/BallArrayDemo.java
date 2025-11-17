package com.chap03;

class Ball {
    String name;
    public Ball(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
public class BallArrayDemo {
    public static void main(String[] args) {
        Ball[] balls = new Ball[5];

        for (int i = 0; i < 2; i++) {
            balls[i] = new Ball("야구_"+i);
        }
        System.out.println("배열의 원소들 : ");
        for(Ball ball : balls){
            if(ball != null)
                System.out.println(ball.getName());
        }
    }
}
