public class Americano extends AbstractCoffee {


    String name;
    String whatbean;

    @Override
    public void order(String what) {
        what = this.name;
        System.out.println(what + " 주문했습니다.");
    }

    @Override
    public void selectBean(String whatbean) {
        whatbean = this.whatbean;
        System.out.println(" 해당 " + whatbean + "선택하셨습니다." );
    }

    @Override
    public void extractBean() {
        System.out.println(whatbean + " 추출 합니다. ");
    }

    @Override
    public void stiring() {
        System.out.println("휘젓습니다.");
    }

    @Override
    public void bring() {
        System.out.println("가져 가세요!!");
    }
}
