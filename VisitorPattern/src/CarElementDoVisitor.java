import framework.*;

public class CarElementDoVisitor implements CarElementVisitor {

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Kicking my " + wheel.getName() + " wheel");
    }

    @Override
    public void visit(Engine wheel) {
        System.out.println("Starting my engine");
    }

    @Override
    public void visit(Body wheel) {
        System.out.println("Moving my body");
    }

    @Override
    public void visit(Car wheel) {
        System.out.println("Starting my car");
    }
}
