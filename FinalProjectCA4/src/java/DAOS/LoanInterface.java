/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DTOS.Loan;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dhruman
 */
public interface LoanInterface {

    public List<Loan> getAllCurrentLoans(int user_id);

    public boolean insertRowLoan(int Loan_id, int user_id, int book_isbn, Date loan_startdate, Date loan_duedate, Date loan_returningdate);

    public List<Loan> getAllLoanHistory();

    public List<Loan> getLoanByUserId(String user_id);
}
