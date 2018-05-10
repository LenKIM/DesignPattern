public class BigString {

    //큰 문자의 배열
    private BigChar[] bigChars;

    //생성자
    public BigString(String string, boolean shared){
        bigChars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigChars.length; i++) {
            if(shared)
                bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    //표시
    public void print(){
        for (int i = 0; i < bigChars.length; i++) {
            bigChars[i].print();
        }
    }
}
