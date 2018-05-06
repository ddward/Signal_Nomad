package com.example.david.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by David on 4/13/2018.
 */

//DW: Functions that can be called to interact with the database per-Room Persistence Library specifications

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
