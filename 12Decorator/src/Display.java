public abstract class Display {
    public abstract int getColumns(); // 가로 문자수를 얻는다.

    public abstract int getRows(); // 세로 행수를 얻는다.

    public abstract String getRowText(int row); // row번째의 문자열을 얻는다.

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
