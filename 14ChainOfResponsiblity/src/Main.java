public class Main {

    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("LimitSupport Bob", 100);
        Support c = new SpecialSupport("SpecialSupport 429", 429);
        Support d = new LimitSupport("LimitSupport 200", 200);
        Support e = new SpecialSupport("SpecialSupport 100", 100);
        Support f = new OddSupport("OddSupport");
        Support h = new LimitSupport("00000000000219u39817293", 300);

        //사슬의 형성
        alice.setNext(bob).setNext(c).setNext(d).setNext(e).setNext(f).setNext(h);

//        다양한 트러블 생성
        for (int i = 0; i < 500; i+= 33) {
            alice.support(new Trouble(i));
        }
    }
}
