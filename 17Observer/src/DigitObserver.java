public class DigitObserver implements Observer{
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.genNumber());
        try {

            Thread.sleep(100);

        } catch (InterruptedException e){

        }
    }
}
