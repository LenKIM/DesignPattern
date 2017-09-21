package idcard;

import framework.Factory;
import framework.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IdCardFactory extends Factory {
    private List owner = new ArrayList();
    private HashMap database = new HashMap();
    private int serial = 100;

    @Override
    protected void registerProduct(Product p) {
        IDCard card = (IDCard) p;
        database.put(new Integer(card.getSerial()), card.getOwner());
    }

    @Override
    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    public List getOwner() {
        return owner;
    }
}
