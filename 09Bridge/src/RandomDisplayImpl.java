import java.util.Random;

public class RandomDisplayImpl extends DisplayImpl {

    private int width;
    private int input;
    public RandomDisplayImpl(int i) {
        this.width = 10;
        input = i;
    }

    @Override
    public void rawOPen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        Random random = new Random();
        int a =  random.nextInt(input);
        System.out.print(" | " + a +" | ");
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) { // width개의 "-"표시하여
            System.out.print("-"); // 테두리의 선으로 이용
        }
        System.out.println("+"); // 테두리의 모서리를 표현하는 + 마크를 표시
    }
}
