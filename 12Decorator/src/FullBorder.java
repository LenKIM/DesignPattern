public class FullBorder extends Border {

    public FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() { // 문자수는 내용물의 양쪽에 좌우의 장식문자수를 더한 것
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() { // 행수는 내용물의 행수에 상하의 장식문자수를 더한 것
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) { //지정한 행의 내용
        if (row == 0) {                   // 장식의 상단
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) { // 장식의 하단
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {
            return "|" + display.getRowText(row - 1) + "|";
        }
    }

    private String makeLine(char ch, int count) { //문자 ch를 count개 연속시킨 문자열을 만든다.
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
