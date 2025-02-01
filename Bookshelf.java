import java.util.ArrayList;
import java.util.stream.Collectors;

public class Bookshelf 
{
    private ArrayList<Book> booklist;

    Bookshelf()
    {
        this.booklist = new ArrayList<Book>();
    }
    
    public ArrayList<Book> getBookList()
    {
        return this.booklist;
    }

    public void addBooks(ArrayList<Book> booksToAdd)
    {
        this.booklist.addAll(booksToAdd);
    }

    public void removeBooks(ArrayList<Book> booksToRemove)
    {
        this.booklist.removeAll(booksToRemove);
    }

    public ArrayList<Book> findBooksByTitle(String title)
    {
        return this.booklist.stream()
        .filter(book -> book.getTitle().contains(title))
        .collect(Collectors.toCollection(ArrayList::new));
    }
}
