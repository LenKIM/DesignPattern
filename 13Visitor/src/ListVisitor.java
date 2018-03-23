import java.util.Iterator;

public class ListVisitor extends Visitor {

    private String currentDir = ""; //현재 주목하고 있는 디렉토리 이름

    @Override
    public void visit(File file) { // 파일을 방문할 때 호출
        System.out.println(currentDir + "/" + file);
    }

    @Override
    public void visit(Directory directory) { //디렉토리를 방문할 때 호출
        System.out.println(currentDir + "/" + directory);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();

        Iterator it = directory.iterator();
        while (it.hasNext()){
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
        currentDir = saveDir;
    }
}
