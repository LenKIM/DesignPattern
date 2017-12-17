import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class I0000LabCoffeeStore extends CoffeeFactory {

    private List coffeeKinds = new ArrayList();
    private HashMap database = new HashMap();
    private int serial = 100;

    @Override
    protected Coffee createCoffee(String what) {
        return new Americano(what, "이천원");
    }

    @Override
    protected void makeCoffee(Coffee coffee) {

    }
}
