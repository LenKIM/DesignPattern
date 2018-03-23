/**
 * Visitor 클래스는 '방문자'를 나타내는 클래스
 */
public abstract class Visitor {

    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
