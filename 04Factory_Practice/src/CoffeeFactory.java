/**
 *  커피 공장
 */
public abstract class CoffeeFactory {

    public Coffee create(String What){
        Coffee coffee = createCoffee(What);
        makeCoffee(coffee);
        return coffee;
    }

    protected abstract Coffee createCoffee(String What);
    protected abstract void makeCoffee(Coffee coffee);

}
