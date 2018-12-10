/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import java.util.Date;

/**
 *
 * @author Dhruman 
 *
 */
public class Loan {

    // Declaring the fileds from database which we use use in  Loan Table
    private int loan_id;
    private int user_id;
    private int book_isbn;
    private Date loan_startdate;
    private Date loan_duedate;
    private Date loan_returndate;

    //default constuctor
    public Loan() {

    }
    //parameter constuctor

    public Loan(int Loan_id, int user_id, int book_isbn, Date loan_startdate, Date loan_duedate, Date loan_returndate) {
        this.loan_id = Loan_id;
        this.user_id = user_id;
        this.book_isbn = book_isbn;
        this.loan_startdate = loan_startdate;
        this.loan_duedate = loan_duedate;
        this.loan_returndate = loan_returndate;
    }
    //getter and setter methods

    public int getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(int Loan_id) {
        this.loan_id = Loan_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(int book_isbn) {
        this.book_isbn = book_isbn;
    }

    public Date getLoan_startdate() {
        return loan_startdate;
    }

    public void setLoan_startdate(Date loan_startdate) {
        this.loan_startdate = loan_startdate;
    }

    public Date getLoan_duedate() {
        return loan_duedate;
    }

    public void setLoan_duedate(Date loan_duedate) {
        this.loan_duedate = loan_duedate;
    }

    public Date getLoan_returndate() {
        return loan_returndate;
    }

    public void setLoan_returndate(Date loan_returndate) {
        this.loan_returndate = loan_returndate;
    }

    // hascode method in this method going to search for user id and loand id adn book isbn number
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.loan_id;
        hash = 23 * hash + this.user_id;
        hash = 23 * hash + this.book_isbn;
        return hash;
    }

    //equal to method is going to cheack for user id and loand id adn book isbn number thats is not same 
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
        final Loan other = (Loan) obj;
        if (this.loan_id != other.loan_id) {
            return false;
        }
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.book_isbn != other.book_isbn) {
            return false;
        }

        return true;
    }
    //toString method is going to diplay the data 

    @Override
    public String toString() {
        return "Loan{" + "Loan_id=" + loan_id + ", user_id=" + user_id + ", book_isbn=" + book_isbn + ", loan_startdate=" + loan_startdate + ", loan_duedate=" + loan_duedate + ", loan_returndate=" + loan_returndate + '}';
    }
    

}
