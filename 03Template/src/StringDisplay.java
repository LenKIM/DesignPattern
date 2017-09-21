public class StringDisplay extends AbstractDisplay {

    String content;
    int width;

    public StringDisplay(String content) {
        this.content = content;
        this.width = content.getBytes().length;
    }

    @Override
    public void open() {
        printLine();
    }


    @Override
    public void print() {
        System.out.println("|" + content + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.print("+");
    }


}
