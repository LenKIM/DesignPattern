public class TextBuilder implements Builder {

    private StringBuffer buffer = new StringBuffer(); //필드의 문서를 구축

    @Override
    public void makeTitle(String title) {
        buffer.append("======================\n");
        buffer.append("{" + title + "}");
        buffer.append("\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append('ㅁ' + str + '\n');
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            buffer.append(" 0" + items[i] + "\n");
            buffer.append("\n");
        }
    }

    @Override
    public void close() {
        buffer.append("=======================");
    }

    public String getResult(){
        return buffer.toString();
    }
}
