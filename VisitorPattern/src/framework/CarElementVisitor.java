package framework;

public interface CarElementVisitor {
    void visit(Wheel wheel);
    void visit(Engine wheel);
    void visit(Body wheel);
    void visit(Car wheel);
}
