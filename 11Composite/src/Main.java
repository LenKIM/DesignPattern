public class Main {

    public static void main(String[] args) {

        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory bindir = new Directory("bin");
        Directory tmpdir = new Directory("tmp");
        Directory usrDir = new Directory("usr");
        rootDir.add(bindir);
        rootDir.add(tmpdir);
        rootDir.add(usrDir);
        bindir.add(new File("vi", 10000));
        bindir.add(new File("latex", 20000));
        rootDir.printList();

        System.out.println("");
        System.out.println("Making user entries...");
        Directory Kim = new Directory("Kim");
        Directory Lee = new Directory("Lee");
        Directory Park = new Directory("Park");
        usrDir.add(Kim);
        usrDir.add(Lee);
        usrDir.add(Park);
        Kim.add(new File("diaryh.html", 100));
        Kim.add(new File("composite.html", 200));
        Lee.add(new File("memo.txt", 300));
        Park.add(new File("game.doc", 400));
        Park.add(new File("junk.mail", 500));
        rootDir.printList();

    }
}
