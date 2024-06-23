import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main 
{
    static Scanner scanner = new Scanner(System.in);
    Bookshelf bookshelf = new Bookshelf();
    public static void main(String[] args)
    {
        Main main = new Main();
        main.addBooks();
        main.removeBooks();
    }

    void showAllBooks()
    {
        var booklist = bookshelf.getBookList();

    }

    void addBooks()
    {
        var booksToAdd = new ArrayList<Book>
        (
            Arrays.asList(
                new Book("Book1", "Publisher1", "2023-01-01", "Author1"),
                new Book("Book2", "Publisher2", "2022-12-15", "Author2"),
                new Book("Book3", "Publisher3", "2022-11-30", "Author3"),
                new Book("Book2", "Publisher4", "2022-10-20", "Author4")
            )
        );

        bookshelf.addBooks(booksToAdd);
    }

    //消す本を探す、消す作業を分離
    void removeBooks()
    {
        //タイトル入力
        var title = "Book2";

        //タイトルが一致する本を探す
        var bookList = bookshelf.getBookList();
        var booksToRemove = bookList.stream()
        .filter(book -> book.getTitle().equals(title))
        .collect(Collectors.toCollection(ArrayList::new));

        for(Book book : booksToRemove)
        {
            System.out.println(book.getTitle());
        }
        // Book2
        // Book2

        //消す
        bookshelf.removeBooks(booksToRemove);
        bookList = bookshelf.getBookList();

        for(Book book : bookList)
        {
            System.out.println(book.getTitle());
        }
        // Book1
        // Book3
    }
}