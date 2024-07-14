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
        main.showAllBooks();
        main.addBooks();
        main.removeBooks();
        main.showAllBooks();
    }

    void showAllBooks()
    {
        var booklist = bookshelf.getBookList();

        for(Book book : booklist)
        {
            showBook(book);
        }
    }

    void showBook(Book book)
    {
        System.out.println(String.format("title:%s", book.getTitle()));
    }

    void searchBooks()
    {
        System.out.println("input title of books to search.");
        var bookList = bookshelf.getBookList();
        var title = scanner.nextLine();
        var searchingBooks = bookList.stream()
        .filter(book -> book.getTitle().contains(title))
        .collect(Collectors.toCollection(ArrayList::new));

        for(Book book : searchingBooks)
        {
            showBook(book);
        }
    }

    void addBooks()
    {
        var booksToAdd = new ArrayList<Book>
        (
            Arrays.asList(
                new Book("Book1", "Publisher1", "2023-01-01", new ArrayList<String>(Arrays.asList("Author1"))),
                new Book("Book2", "Publisher2", "2022-12-15", new ArrayList<String>(Arrays.asList("Author2"))),
                new Book("Book3", "Publisher3", "2022-11-30", new ArrayList<String>(Arrays.asList("Author3"))),
                new Book("Book2", "Publisher4", "2022-10-20", new ArrayList<String>(Arrays.asList("Author4"))),
                new Book("Book267", "Publisher5", "2020-10-20", new ArrayList<String>(Arrays.asList("Author5")))
            )
        );

        bookshelf.addBooks(booksToAdd);
    }

    //消す本を探す、消す作業を分離
    void removeBooks()
    {
        //タイトル入力
        var title = "Book2";

        //タイトルが部分一致する本を探す
        var bookList = bookshelf.getBookList();
        var booksToRemove = bookList.stream()
        .filter(book -> book.getTitle().contains(title))
        .collect(Collectors.toCollection(ArrayList::new));

        for(Book book : booksToRemove)
        {
            System.out.println(book.getTitle());
        }
        // Book2
        // Book2
        // Book267

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