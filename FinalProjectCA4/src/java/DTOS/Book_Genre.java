package DTOS;

/**
 *
 * @author Andrew
 */
public class Book_Genre {

    private int book_isbn;
    private int genre_id;

    public Book_Genre() {

    }

    public Book_Genre(int book_isbn, int genre_id) {
        this.book_isbn = book_isbn;
        this.genre_id = genre_id;
    }

    public int getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(int book_isbn) {
        this.book_isbn = book_isbn;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.book_isbn;
        hash = 11 * hash + this.genre_id;
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
        final Book_Genre other = (Book_Genre) obj;
        if (this.book_isbn != other.book_isbn) {
            return false;
        }
        if (this.genre_id != other.genre_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book_Genre{" + "book_isbn=" + book_isbn + ", genre_id=" + genre_id + '}';
    }

}
