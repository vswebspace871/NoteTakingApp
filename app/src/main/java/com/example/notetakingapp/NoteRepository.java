package com.example.notetakingapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {

    private NoteDAO noteDAO;
    private LiveData<List<Note>> notes;

    public NoteRepository(Application application){

        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDAO = database.noteDAO();
        notes = noteDAO.getAllNotes();
    }

    public void Insert(Note note)
    {
        new InsertNoteAsyncTask(noteDAO).execute(note);
    }

    public void update(Note note)
    {
        new UpdateNoteAsyncTask(noteDAO).equals(note);
    }

    public void delete(Note note)
    {
        new DeleteNoteAsyncTask(noteDAO).execute(note);
    }

    public LiveData<List<Note>> getAllNotes()
    {
        return notes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void>
    {
        private NoteDAO noteDAO;

        private InsertNoteAsyncTask(NoteDAO noteDAO)
        {
            this.noteDAO = noteDAO;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.Insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void>
    {
        private NoteDAO noteDAO;

        private UpdateNoteAsyncTask(NoteDAO noteDAO)
        {
            this.noteDAO = noteDAO;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.Update(notes[0]);
            return null;
        }
    }
    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void>
    {
        private NoteDAO noteDAO;

        private DeleteNoteAsyncTask(NoteDAO noteDAO)
        {
            this.noteDAO = noteDAO;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.Delete(notes[0]);
            return null;
        }
    }
}
