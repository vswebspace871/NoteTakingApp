package com.example.notetakingapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao             // room database ko batane ke liye DAO likhna hai
public interface NoteDAO {
//    CRUD operation (Insert, delete, update, read) k method yaha banenge, method body nahi banegi


//    insert method
    @Insert   //room database ko batane k liye ki ye insert method hai
    void Insert(Note note);

    // update method
    @Update
    void Update(Note note);

    //delete method
    @Delete
    void Delete(Note note);

    //read method return type list which will update LIVE
    @Query("SELECT * FROM note_table ORDER BY id ASC")
    LiveData<List<Note>> getAllNotes();

    //room or sqlite database me sabse bada antar ye hai ki ROOM sql
    // query likhte waqt hi error show kr deta hai redline se
    //jabki sqlite me aisa nahi hota hai, APP run hone ke baad error pata chalta hai
}
