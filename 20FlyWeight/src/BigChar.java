import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {

    //문자의 이름
    private char charname;

    //큰 문자를 표현하는 문자열('#' ',' '\ㅜ' 의 열
    private String fontdata;

    public BigChar(char charname) {
        this.charname = charname;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("big" + charname + ".txt"));
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line  = reader.readLine()) != null){
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontdata = buf.toString();
        } catch (IOException e){
            this.fontdata = charname + "?";
        }
    }
    // 큰 문자를 표현 한다.
    public void print(){
        System.out.println(fontdata);
    }
}
