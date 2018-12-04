/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DTOS.Loan;
import DTOS.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dhruman
 */
public class LoanDAO extends DAO implements LoanInterface{

    public LoanDAO(String databaseName) {
        super(databaseName);
    }

    @Override
    public List<Loan> getAllCurrentLoans(int user_id) {
      Connection con = null;
                  PreparedStatement ps = null;
                  ResultSet rs = null;
                  List<Loan> currentLoans = new ArrayList();
                        
                  try{
                           con = getConnection();

                           String query = "Select * from loan where user_id = ?";
                          ps.setInt(1, user_id);
                           ps = con.prepareStatement(query);
                           rs = ps.executeQuery(); 
            
                           while(rs.next()){
                                    //User us1 = new User(rs.getInt("user_id"), rs.getString("firstName"), rs.getString("lastName"), rs.getInt("age"), rs.getString("Email"), rs.getString("phoneNo"), rs.getString("password"), rs.getString("addressLine1"), rs.getString("addressLine2"), rs.getString("addressLine3"), rs.getString("county"), rs.getBoolean("isAdmin"));
                                    Loan l = new Loan(rs.getInt("loan_id"),rs.getInt("user_id"),rs.getInt("book_isbn"),rs.getDate("loan_startdate"),rs.getDate("loan_duedate"),rs.getDate("loan_returningdate"));
                                    currentLoans.add(l);
                           }
                  }catch (SQLException e) {
                           System.out.println("Exception occured in the getAllCurrentLoans() method: " + e.getMessage());
                  } finally {
                             try {
                                    if (rs != null) {
                                             rs.close();
                                    }
                                    if (ps != null) {
                                             ps.close();
                                    }
                                    if (con != null) {
                                             freeConnection(con);
                                    }
                  } catch (SQLException e) {
                           System.out.println("Exception occured in the finally section of the getUserByEmail() method: " + e.getMessage());
                  }
        }
            
            return currentLoans;
                  
    }

    @Override
    public boolean insertRowLoan(int Loan_id, int user_id, int book_isbn, Date loan_startdate, Date loan_duedate, Date loan_returningdate) {
         Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                List<Loan> currentLoans = new ArrayList();
                
                Loan ln1 = new Loan(Loan_id, user_id, book_isbn, loan_startdate, loan_duedate, loan_returningdate);
                        
                try{
                con = getConnection();
                String query = "INSERT INTO Loan VALUES (?, ?, ?, ?, ?, ?)";
                ps.setInt(1, ln1.getLoan_id());
                ps.setInt(2, ln1.getUser_id());
                ps.setInt(3, ln1.getBook_isbn());
                ps.setDate(4, (java.sql.Date) ln1.getLoan_startdate());
                ps.setDate(5, (java.sql.Date) ln1.getLoan_duedate());
                ps.setDate(6, (java.sql.Date) ln1.getLoan_returningdate());

                           ps = con.prepareStatement(query);
                           rs = ps.executeQuery(); 
                           
                }catch (SQLException e) {
                           System.out.println("Exception occured in the insertRowLoan() method: " + e.getMessage());
                           return false;
                } finally {
                             try {
                                    if (rs != null) {
                                             rs.close();
                                    }
                                    if (ps != null) {
                                             ps.close();
                                    }
                                    if (con != null) {
                                             freeConnection(con);
                                    }
                  } catch (SQLException e) {
                           System.out.println("Exception occured in the finally section of the insertRowLoan() method: " + e.getMessage());
                  }
               }
                return true;
    }

    @Override
    public List<Loan> getAllLoanHistory() {
         Connection con = null;
         PreparedStatement ps = null;
         ResultSet rs = null;
         List<Loan> loans = new ArrayList();
            
         try{
            con = getConnection();

            String query = "Select * from loanHistory";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 

            
            while(rs.next()){
              Loan history = new Loan(rs.getInt("loan_id"),rs.getInt("user_id"),rs.getInt("book_isbn"),rs.getDate("loan_startdate"),rs.getDate("loan_duedate"),rs.getDate("loan_returningdate"));
                loans.add(history);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllLoans() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllLoans() method: " + e.getMessage());
            }
        }
            
            return loans;
    }

    @Override
    public List<Loan> getLoanByUserId(String user_id) {
        Connection con = null;
         PreparedStatement ps = null;
         ResultSet rs = null;
         List<Loan> loans = new ArrayList();
            
         try{
            con = getConnection();

            String query = "Select * from loanhistory where user_id = ?";
            //throws null pointer exception if ln 76 and ln 77 are in the wrong order
            ps = con.prepareStatement(query);
            ps.setString(1, user_id);
            rs = ps.executeQuery(); 
            
            while(rs.next()){
                Loan history = new Loan(rs.getInt("loan_id"),rs.getInt("user_id"),rs.getInt("book_isbn"),rs.getDate("loan_startdate"),rs.getDate("loan_duedate"),rs.getDate("loan_returningdate"));
                loans.add(history);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllLoans() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllLoans() method: " + e.getMessage());
            }
        }
            
            return loans;
        } 
    }

   


