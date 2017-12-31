import framework.*;

public class CarElementPrintVisitor implements CarElementVisitor {

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Visiting " + wheel.getName() + "wheel");
    }

    @Override
    public void visit(Engine wheel) {
        System.out.println("Visiting engine");
    }

    @Override
    public void visit(Body wheel) {
        System.out.println("Visiting body");
    }

    @Override
    public void visit(Car wheel) {
        System.out.println("Visiting car");
    }
}
