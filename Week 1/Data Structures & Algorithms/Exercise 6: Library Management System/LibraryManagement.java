package Exercise_6;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagement
{

    private List<Book> books;

    public LibraryManagement()
    {
        books = new ArrayList<>();
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public Book linearSearchByTitle(String title)
    {
        for (Book book : books)
        {
            if (book.getTitle().equalsIgnoreCase(title))
            {
                return book;
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title)
    {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);

            int cmp = midBook.getTitle().compareToIgnoreCase(title);

            if (cmp == 0)
            {
                return midBook;
            }
            if (cmp < 0)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return null;
    }

    public void sortBooksByTitle()
    {
        books.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
    }
}
