package Business;

/**
 *
 * @author Andrew
 */
public class Genre {
    int genre_id;
    String genre_category;
    
    public Genre() {
        
    }

    public Genre(int genre_id, String genre_category) {
        this.genre_id = genre_id;
        this.genre_category = genre_category;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre_category() {
        return genre_category;
    }

    public void setGenre_category(String genre_category) {
        this.genre_category = genre_category;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.genre_id;
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
        final Genre other = (Genre) obj;
        if (this.genre_id != other.genre_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Genre{" + "genre_id=" + genre_id + ", genre_category=" + genre_category + '}';
    }
    
    
    
    
}
