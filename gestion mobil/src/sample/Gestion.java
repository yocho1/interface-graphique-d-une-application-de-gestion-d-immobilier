package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Gestion {


    private int id;
    private String Lname;
    private String Fname;
    private int numver;

    public Gestion(int id, String Fname, String Lname, int numver) {
        this.id = id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.numver = numver;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fName) {
        this.Fname = fName;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lName) {
        this.Lname = lName;
    }

    public int getNumver() {
        return numver;
    }

    public void setNumver(int numver) {
        this.numver = numver;
    }


}
