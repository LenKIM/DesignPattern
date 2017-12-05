public abstract class AbstractCoffee {

    public abstract void order(String what);
    public abstract void selectBean(String whatbean);
    public abstract void extractBean();
    public abstract void stiring();
    public abstract void bring();

    public final void process(String what, String whatbean){
        order(what);
        selectBean(whatbean);
        extractBean();
        stiring();
        bring();
    }
}
