public class SideBorder extends Border {

    private char borderChar;

    public SideBorder(Display display, char borderChar) {
        super(display); // 생성자에서 Display라는 장식 문자를 지정
        this.borderChar = borderChar;
    }

    @Override
    public int getColumns() { // 문자수는 내용물의 양쪽에 정식 문자수를 더한 것
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() { // 행수는 내용물의 애수와 동일
        return display.getRows();
    }

    @Override
    public String getRowText(int row) { // 지정된 행의 내용은 내용물의 지정된 행의 양쪽에 장식 문자를 붙인 것
        return borderChar + display.getRowText(row) + borderChar;
    }
}
