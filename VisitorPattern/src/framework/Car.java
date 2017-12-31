package framework;

public class Car implements CarElement {

    CarElement[] elements;

    public CarElement[] getElements() {
        return elements;
    }

    public Car() {
        this.elements = new CarElement[]
                {new Wheel("Front left"), new Wheel("Front right"),
                new Wheel("Back left"), new Wheel("Back right"),
                new Body(), new Engine()};
    }

    @Override
    public void accept(CarElementVisitor visitor) {
        for (CarElement element: this.getElements()){
            element.accept(visitor);
        }
            visitor.visit(this);
        }
    }
