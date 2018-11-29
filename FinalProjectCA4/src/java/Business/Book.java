package Business;

/**
 *
 * @author Andrew
 */
public class Book {
    
    int book_isbn;
    String book_title;
    String book_author;
    String book_publisher;
    String book_description;
    int book_quantity;
    Double book_stock;
    
    public Book() {
        
    }

    public Book(int book_isbn, String book_title, String book_author, String book_publisher, String book_description, int book_quantity, Double book_stock) {
        this.book_isbn = book_isbn;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_publisher = book_publisher;
        this.book_description = book_description;
        this.book_quantity = book_quantity;
        this.book_stock = book_stock;
    }

    public int getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(int book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public int getBook_quantity() {
        return book_quantity;
    }

    public void setBook_quantity(int book_quantity) {
        this.book_quantity = book_quantity;
    }

    public Double getBook_stock() {
        return book_stock;
    }

    public void setBook_stock(Double book_stock) {
        this.book_stock = book_stock;
    }

    @Override
    public String toString() {
        return "Book{" + "book_isbn=" + book_isbn + ", book_title=" + book_title + ", book_author=" + book_author + ", book_publisher=" + book_publisher + ", book_description=" + book_description + ", book_quantity=" + book_quantity + ", book_stock=" + book_stock + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.book_isbn;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.book_isbn != other.book_isbn) {
            return false;
        }
        return true;
    }
    
    
    
    
}
