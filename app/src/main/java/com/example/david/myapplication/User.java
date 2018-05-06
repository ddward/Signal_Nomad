package com.example.david.myapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Bundle;



/**
 * Created by David on 4/13/2018.
 */

//DW: definitions of a table, as required by Room Persistence Library
////reference: https://developer.android.com/training/data-storage/room/
@Entity
public class User{

    @PrimaryKey(autoGenerate = true)
    public int locid;

    @ColumnInfo(name = "Latitude")
    public Double Latitude;

    @ColumnInfo(name = "Longitude")
    public Double Longitude;

    @ColumnInfo(name = "Signal_Strength")
    public String Signal_Strength;

}
