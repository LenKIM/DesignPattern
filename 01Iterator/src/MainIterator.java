//Aggregate 인터페이스
public class MainIterator {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Android 1"));
        bookShelf.appendBook(new Book("Bible 01"));
        bookShelf.appendBook(new Book("Game 02"));
        bookShelf.appendBook(new Book("Fish "));
        Iterator it = bookShelf.iterator();
        while (it.hasNext()){
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
