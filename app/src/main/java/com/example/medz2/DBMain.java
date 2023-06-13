package com.example.medz2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBMain extends SQLiteOpenHelper {
    private Context context;
private static final String DBNAME="pillz.db";

static final String TABLENAME="pills";
private static final String PILL_ID="pill_id";
private static final String PILL_NAME="pill_name";
    private static final String PILL_TYPE="pill_type";

private static final String NO_OF_WEEKS="no_of_weeks";
    private static final String FORM="form";
    private static final String START="start_date";
    private static final String STOP="stop_date";
    private static final String TIME="time";
static final int VER=1;

   DBMain(@Nullable Context context) {
        super(context, DBNAME, null, VER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table  " + TABLENAME + " (" + PILL_ID + " TEXT PRIMARY KEY, " +
                PILL_NAME + " TEXT, " +
                PILL_TYPE + " TEXT, "+
                NO_OF_WEEKS + " TEXT, " +
                FORM + " TEXT,  " +
                START + " DATE, " +
                STOP + " TEXT, " +
                TIME +" TEXT);"
        ;
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       db.execSQL("drop table if exists "+ TABLENAME);
        onCreate(db);

    }
    void add(String pill_id, String pill_name , String pill_type,String no_of_weeks, String form, String start_date, String stop_date, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PILL_ID, pill_id);
        cv.put(PILL_NAME, pill_name);
        cv.put(PILL_TYPE, pill_type);
        cv.put(NO_OF_WEEKS, no_of_weeks);
        cv.put(FORM, form);
        cv.put(START, start_date);
        cv.put(STOP, stop_date);
        cv.put(TIME, time);
        long result = db.insert(TABLENAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();


        }
    }
    Cursor readAllData() {
        String query="select * from " + TABLENAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;
        if(db!=null) {
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }
    void updateData(String row_id,String pill_name,String pill_type,String no_of_weeks,String form,String start_date,String stop_date,String time){
       SQLiteDatabase db=this.getWritableDatabase();
       ContentValues cv=new ContentValues();
        cv.put(PILL_ID, row_id);
        cv.put(PILL_NAME, pill_name);
        cv.put(PILL_TYPE, pill_type);
        cv.put(NO_OF_WEEKS, no_of_weeks);
        cv.put(FORM, form);
        cv.put(START, start_date);
        cv.put(STOP, stop_date);
        cv.put(TIME, time);
        long result=db.update(TABLENAME,cv,"pill_id=?",new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "failed to update", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(context, "successfully updated", Toast.LENGTH_SHORT).show();


        }

    }
    void deleteData(String row_id) {
       SQLiteDatabase db=this.getWritableDatabase();
       long result=db.delete(TABLENAME,"pill_id=?",new String[] {row_id});
        if (result == -1) {
            Toast.makeText(context, "failed to delete", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(context, "successfully deleted", Toast.LENGTH_SHORT).show();


        }
    }
}
