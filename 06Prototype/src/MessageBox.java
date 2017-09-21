import framework.Product;

public class MessageBox implements Product {

    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println(length);
        for (int i = 0; i < length+4; i++) {
            System.out.print(decochar);
        }
        System.out.print(" ");
        System.out.println(decochar + " " + s + " " + decochar);
        for (int i = 0; i < length+4; i++) {
            System.out.println(decochar);
        }
        System.out.print(" ");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
