package idcard;

import framework.Product;

public class IDCard extends Product {

    private String owner;
    private int serial;

    //접근 제어자가 없을 때는 오직 동일 패키지내에서만 사용가능하다.
    IDCard(String owner, int serial) {
        System.out.println(owner + "의 카드" + serial + "를 만듭니다.");
        this.owner = owner;
        this.serial = serial;
    }

    @Override
    public void use(){
        System.out.println(owner + "의 카드를 사용합니다.");
    }

    public String getOwner(){
        return owner;
    }

    public int getSerial() {
        return serial;
    }
}
