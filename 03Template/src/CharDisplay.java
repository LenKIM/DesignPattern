public class CharDisplay extends AbstractDisplay {

    char contents;

    public CharDisplay(char contents) {
        this.contents = contents;
    }

    @Override
    public void open() {
        System.out.println("<<");
    }

    @Override
    public void print() {
        System.out.println(contents);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
