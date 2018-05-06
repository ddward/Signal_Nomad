package com.example.david.myapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by David on 4/13/2018.
 */

//DW Creation of database class
//reference: https://developer.android.com/training/data-storage/room/

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}




