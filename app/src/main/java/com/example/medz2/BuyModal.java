package com.example.medz2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// below line is for setting table name.
@Entity(tableName = "course_table")
public class BuyModal {


    @PrimaryKey(autoGenerate = true)

    // variable for our id.
    private int id;


    private String pillName;


    private String pillQuantity;



    public BuyModal(String pillName, String pillQuantity) {
        this.pillName = pillName;
        this.pillQuantity = pillQuantity;

    }
    public String getPillName() {
        return pillName;
    }

    public String getPillQuantity() {
        return pillQuantity;
    }

    public void setPillQuantity(String pillQuantity) {
        this.pillQuantity = pillQuantity;
    }

    public void setPillName(String pillName) {
        this.pillName = pillName;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

