package Business;

/**
 *
 * @author Andrew
 */
public class Book_Genre {
    int book_id;
    int genre_id;
    
    public Book_Genre() {
        
    }
    
    public Book_Genre(int book_id, int genre_id) {
        this.book_id = book_id;
        this.genre_id = genre_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
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
        hash = 11 * hash + this.book_id;
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
        if (this.book_id != other.book_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book_Genre{" + "book_id=" + book_id + ", genre_id=" + genre_id + '}';
    }
    
    
    
}
