package example02;

/**
 * 이전 01에는 클래스에 의한 Adapter패턴이였다면, 이번에는 인스턴스에 의한 'Adapter 패턴'을 봅시다아.
 * 앞에서는 '상속'을 사용했지만 이번에는 '위임을 사용합니다.
 *
 * 위임이란 딱딱한 표현이지만 요약하면 '누군가에게 맡긴다'라는 의미입니다. 중요한 회의에 출석할 수 없을 때 '나는 출석할 수 없지만, 대신 김영진 씨를 출석시키겠습니다'라는 위임장을 씁니다.
 * 위임이란 이양과 같습니다 JAVA에서 위임은 어떤 메소드의 실제 처리를 다른 인스턴스의 메소드에 맡기는 것을 말합니다.
 */

public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen(){
        System.out.println("(" + string + ")");
    }

    public void showWithAster(){
        System.out.println("*" + string + "*");
    }
}
