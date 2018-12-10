package DTOS;
import java.sql.Date;

/**
 *
 * @author Andrew
 */
public class Fee {
    private int fee_id;
    private int user_id;
    private int book_id;
    private int card_no;
    
    public Fee() {
        
    }

    public int getFee_id() {
        return fee_id;
    }

    public void setFee_id(int fee_id) {
        this.fee_id = fee_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCard_no() {
        return card_no;
    }

    public void setCard_no(int card_no) {
        this.card_no = card_no;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.fee_id;
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
        final Fee other = (Fee) obj;
        if (this.fee_id != other.fee_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fee{" + "fee_id=" + fee_id + ", user_id=" + user_id + ", book_id=" + book_id + '}';
    }
    
}
