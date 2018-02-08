public class Hand {

    public static final int HANDVALUE_GUU = 0; //주먹
    public static final int HANDVALUE_CHO = 1; //가위
    public static final int HANDVALUE_PAA = 2; //보

    public static final Hand[] hand = { // 가위바위보의 손을 표시하는 3개의 인스턴스
            new Hand(HANDVALUE_GUU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA),
    };

    private static final String[] name = {
            "주먹", "가위", "보"
    };

    private int handValue;

    public Hand(int handValue) {
        this.handValue = handValue;
    }

    public int getHandValue() {
        return handValue;
    }

    public static Hand getHand(int handValue){
        return hand[handValue];
    }
    public boolean isStrongerThan(Hand h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThan(Hand h) {
        return fight(h) == -1;
    }

    private int fight(Hand h) { // 무승부는  0; this의 승이면 1; h의 승이면 -1
        if (this == h) {
            return 0;
        } else if ((this.handValue + 1) % 3 == h.handValue) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() { // 문자열로 표현
        return name[handValue];
    }

}
