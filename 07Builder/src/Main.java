/**
 *  TextBuilder와 HTMLBuilder는  Builder의 하위 클래스이고 Director는 Builder의 메서드만을 사용해서 문서를 작성합니다.
 *  Builder 의 메소드만을 사용한다는 것은
 *
 *  Director는 실제로 동작하는 것이  TextBuilder인지, HTMLBuilder 인지 모른다는 의미입니다.
 *  따라서 Builder는 문서를 구축하려는 목적을 달성하기 위해서 필요 충분한 메소드군을 선언할 필요가 있습니다.
 *  단, 일반 텍스트나 HTML파일에 고유의 메소드까지 Builder가 제공해서는 안됩니다.
 */
public class Main {
    public static void main(String[] args) {
        if(args.length != 1){
            usage();
            System.exit(0);
        }

        if(args[0].equals("plain")){
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        } else if(args[0].equals("html")){
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String fileName = htmlBuilder.getResult();
            System.out.println(fileName + "가 작성되었습니다.");
        } else {
            usage();
            System.exit(0);
        }
    }
    public static void usage() {
        System.out.println("Usage : Java main plan 일반 텍스트 문서 작성");
        System.out.println("Usage : Java main HTML 일반 텍스트 문서 작성");
    }
}
