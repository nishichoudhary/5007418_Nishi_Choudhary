package Exercise_6;

public class Main
{

    public static void main(String[] args)
    {
        LibraryManagement library = new LibraryManagement();

        library.addBook(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("B002", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("B003", "1984", "George Orwell"));

        library.sortBooksByTitle();

        System.out.println("Linear Search:");
        Book book = library.linearSearchByTitle("1984");
        if (book != null)
        {
            System.out.println(book);
        }
        else
        {
            System.out.println("Book not found.");
        }

        System.out.println("\nBinary Search:");
        book = library.binarySearchByTitle("1984");
        if (book != null)
        {
            System.out.println(book);
        }
        else
        {
            System.out.println("Book not found.");
        }
    }
}
