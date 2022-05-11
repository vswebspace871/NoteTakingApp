package com.example.notetakingapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
//    ye ek ENTITY class hai, matlab datatbase me table ka pahla row kaisa hoga uske liye
//iske baad DAO INTERFACE banta hai



//    database me 3 column banenge, id, title,description
    @PrimaryKey(autoGenerate = true) // id apne aap automatic generate hogi
    public int id; // id ban gayi primary key

    public String title;

    public String description;
    //room database apne aap table sqlite me bana dega or table coulmn bhi bana dega


    //constructor banayenge sirf title or description ka kyunki id autogenerate hogi

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // getters teeno id title or description ka banyenge

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    //setter sirf id ka banyenge

    public void setId(int id) {
        this.id = id;
    }
}
