/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

/**
 *
 * @author HaiKuo
 */
public class User {

    private int user_id;
    private String user_fname;
    private String user_lname;
    private String user_email;
    private String user_password;
    private String user_phoneno;
    private boolean user_isadmin;
    private boolean user_status;

    public User() {

    }

    public User(int user_id, String user_fname, String user_lname, String user_email, String user_password, String user_phoneno, boolean user_isadmin, boolean user_status) {
        this.user_id = user_id;
        this.user_fname = user_fname;
        this.user_lname = user_lname;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_phoneno = user_phoneno;
        this.user_isadmin = user_isadmin;
        this.user_status = user_status;
    }

   

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_fname() {
        return user_fname;
    }

    public void setUser_fname(String user_fname) {
        this.user_fname = user_fname;
    }

    public String getUser_lname() {
        return user_lname;
    }

    public void setUser_lname(String user_lname) {
        this.user_lname = user_lname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phoneno() {
        return user_phoneno;
    }

    public void setUser_phoneno(String user_phoneno) {
        this.user_phoneno = user_phoneno;
    }

    public boolean isUser_isadmin() {
        return user_isadmin;
    }

    public void setUser_isadmin(boolean user_isadmin) {
        this.user_isadmin = user_isadmin;
    }

    public boolean isUser_status() {
        return user_status;
    }

    public void setUser_status(boolean user_status) {
        this.user_status = user_status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.user_id;
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
        final User other = (User) obj;
        if (this.user_id != other.user_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", user_fname=" + user_fname + ", user_lname=" + user_lname + ", user_email=" + user_email + ", user_password=" + user_password + ", user_phoneno=" + user_phoneno + ", user_isadmin=" + user_isadmin + ", user_status=" + user_status + '}';
    }

}
