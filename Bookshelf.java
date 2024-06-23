import java.util.ArrayList;

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
}
