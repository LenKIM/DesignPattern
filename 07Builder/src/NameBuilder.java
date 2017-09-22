public class NameBuilder implements Builder {


    private String userName;
    private int index;

    private StringBuffer buffer = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        buffer.append("너의 이름은");
        buffer.append(":" + title + ":");
        buffer.append("\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append("a " + str + "\n");
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String a:
             items) {
            buffer.append(" -" + a + " \n");
            buffer.append("\n");
        }
    }

    @Override
    public void close() {
        buffer.append("------");
    }

    public String getReuslt(){
        return buffer.toString();
    }
}
