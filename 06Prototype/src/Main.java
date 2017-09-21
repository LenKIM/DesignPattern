//Manager의 인스턴스를 마늗ㄴ다.

import framework.Manager;
import framework.Product;

/**
 * 매니저에 등록하는 내용
 * "string message" => UnderlinePen에서 ulchar가 "~"
 * "warning box" => MessageBox에서 decochar 가 "*"
 * "slash box" => MessageBox에서 decochar 가 "/"
 */
public class Main {

    public static void main(String[] args) {
        //준비
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox messageBox = new MessageBox('*');
        MessageBox slashBox = new MessageBox('/');

        manager.register("strong message", upen);
        manager.register("waring Box", messageBox);
        manager.register("slash box", slashBox);

        //생성
        Product p1 = manager.create("strong message");
        p1.use("Hello world");

        Product p2 = manager.create("waring Box");
        p2.use("Hello world");

        Product p3 = manager.create("slash box");
        p3.use("Hello world");
    }
}
