/**
 * 아메리카노 만들기.
 */
public class Americano extends Coffee{

    String name;
    String price;

    public Americano(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void order(String WhatBean) {
        System.out.println("아메리카노 주문 받았습니다.");
    }

    @Override
    public void extractBean() {
        System.out.println("아메리카노를 위한 샷을 추출합니다.");
    }

    @Override
    public void mixedWith(String Topping) {
        System.out.println("샷과 " + Topping + "섞습니다.");
    }
}
