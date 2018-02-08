public class StringDisplayImpl extends DisplayImpl {

    private String string;
    private int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.getBytes().length; // 바이트 단위의 길이도 필드에 기억해두고 나중에 사용
    }

    @Override
    public void rawOPen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|"); // 앞뒤에 "|"를 붙여서 표시
    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine(){
        System.out.print("+");
        for (int i = 0; i < width; i++) { // width개의 "-"표시하여
            System.out.print("-"); // 테두리의 선으로 이용
        }
        System.out.println("+"); // 테두리의 모서리를 표현하는 + 마크를 표시
    }
}

