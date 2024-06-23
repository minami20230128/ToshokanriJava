public class Book
{
    private String title;
    private String publisher;
    private String date;
    private String author; 

    public Book(String title, String publisher, String date, String author)
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