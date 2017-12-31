package framework;

public interface CarElement {
    void accept(CarElementVisitor visitor); // CarElements have to provice accept();
}
