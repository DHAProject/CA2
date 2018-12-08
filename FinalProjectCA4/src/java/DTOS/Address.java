/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

/**
 *
 * @author Dhruman
 */
public class Address {
    // Declarinf the fileds from database which we use use in  Address Table
    private int user_id;
    private int address_id;
    private String address_1;
    private String address_2;
    private String address_3;
    //default constuctor
    public Address()
    {
        
    }
 //parameter constuctor
    public Address(int user_id, int address_id, String address_1, String address_2, String address_3) {
        this.user_id = user_id;
        this.address_id = address_id;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.address_3 = address_3;
    }
//getter and setter methods
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getAddress_3() {
        return address_3;
    }

    public void setAddress_3(String address_3) {
        this.address_3 = address_3;
    }
// hascode method in this method going to search for user id and Address Id
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.user_id;
        hash = 67 * hash + this.address_id;
        return hash;
    }
 //equal to method is going to cheack for user id and Address Id
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
        final Address other = (Address) obj;
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.address_id != other.address_id) {
            return false;
        }
        return true;
    }
 //toString method is going to diplay the data 
    @Override
    public String toString() {
        return "Address{" + "user_id=" + user_id + ", address_id=" + address_id + ", address_1=" + address_1 + ", address_2=" + address_2 + ", address_3=" + address_3 + '}';
    }
    
    
}
