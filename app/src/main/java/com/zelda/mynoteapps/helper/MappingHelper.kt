package com.zelda.mynoteapps.helper

import android.database.Cursor
import com.zelda.mynoteapps.db.DatabaseContract
import com.zelda.mynoteapps.entity.Note

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<Note>{
        val noteList = ArrayList<Note>()

        notesCursor?.apply {
            while (moveToNext()){
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
                noteList.add(Note(id, title, description, date))
            }
        }
        return  noteList
    }
}