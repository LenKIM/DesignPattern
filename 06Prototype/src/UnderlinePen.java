import framework.Product;

/**
 * MessageBox와 거의 같은 동작을 하지만, ulchar라는 필드가 밑줄로 이용됩니다.
 * use 메서드는 주어진 문자열을 이중 인용부호로 묶으면서 문자열 부분에 밑줄을 그립니다.
 * 예를 들어 ulchar가 '~'일 때 Hello 라는 문자열이 use메서드에 주어지면
 * "Hello"
 * ~~~~~~~
 */
public class UnderlinePen implements Product {

    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }
    @Override
    public void use(String s){
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.println(" ");
        for (int i = 0; i < length; i++) {
            System.out.println(ulchar);
        }
        System.out.println(" ");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
