import java.util.ArrayList;

public class Book
{
    private String title;
    private String publisher;
    private String date;
    private ArrayList<String> author; 

    public Book(String title, String publisher, String date, ArrayList<String> author)
    {
        this.title = title;
        this.publisher = publisher;
        this.date = date;
        this.author = author;
    }

    public String getTitle()
    {
        return this.title;
    }
}