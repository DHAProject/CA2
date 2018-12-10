package DAOS;

import DTOS.Fee;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public interface FeeDAOInterface {
    public ArrayList<Fee> getAllFees();
    public boolean payFees(int user_id);
}
