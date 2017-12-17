public class Main {

    public static void main(String[] args) {

        CoffeeFactory cf = new I0000LabCoffeeStore();

        Coffee amricano = cf.create("아메리카노");

        amricano.order("케나비파베");
        amricano.extractBean();
        amricano.mixedWith("물");
    }
}
